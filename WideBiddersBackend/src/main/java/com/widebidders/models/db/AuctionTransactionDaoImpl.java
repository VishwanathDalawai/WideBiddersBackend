package com.widebidders.models.db;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.AuctionTransaction;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.service.EmailService;

@Repository
public class AuctionTransactionDaoImpl implements AuctionTransactionDao {

	private SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(AuctionMasterDaoImpl.class);

	@Autowired
	public CustomerDaoImpl customerDaoImpl;

	@Autowired
	public AuctionMasterDaoImpl auctionMasterDaoImpl;
	
	@Autowired
	public EmailService emailService;

	public AuctionTransactionDaoImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			logger.error("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public List getAllBids() {
		Session session = factory.openSession();
		Transaction tx = null;
		List auction = null;
		try {
			tx = session.beginTransaction();
			auction = session.createQuery("FROM AuctionTransaction").list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return auction;
	}

	@Override
	public List getBidById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<AuctionTransaction> results = new ArrayList<AuctionTransaction>();
		try {
			tx = session.beginTransaction();
			String hql = "FROM AuctionTransaction WHERE bidId = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);

			List<AuctionTransaction> list = query.list();
			results.addAll(list);

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	@Override
	public int addBid(AuctionTransaction bid, int productId, int customerId) {
		Session session = factory.openSession();
		System.out.println("Hello VPD 1");
		Transaction tx = null;
		AuctionMaster auctionMaster = null;
		Product product = null;
		Customer bidderCustomer = null;
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
        Date date = new Date(currentDate.getTime());
        
        System.out.println("date is"+date);
        System.out.println(currentDate);
		try {
			logger.info("Bid starts for customer "+customerId);
			tx = session.beginTransaction();
			
			List<AuctionMaster> auctionMasterList = session.createQuery("FROM AuctionMaster AM where AM.productSoldStatus=" + 1).list();
			for (Iterator iterator1 = auctionMasterList.iterator(); iterator1.hasNext();) {
				auctionMaster = (AuctionMaster) iterator1.next();
				product = auctionMaster.getProduct();
				if (product.getProductId() == productId) {
					if(auctionMaster.getFinalBidPrice()<bid.getBidAmount()){
						logger.info("Final Bid Price is "+auctionMaster.getFinalBidPrice()+" "+"Bid amount id "+bid.getBidAmount());
						auctionMaster.setFinalBidPrice(bid.getBidAmount());
						bid.setAuctionMaster(auctionMaster);
						bid.setDateTime(currentDate); 
						bidderCustomer = customerDaoImpl.getCustomerById(customerId);
						logger.info("The bidder customer is" + bidderCustomer.getCustomerId());
						bid.setBidderCustomer(bidderCustomer);
						session.save(bid);
						tx.commit();
						return 0;
					}
					break;
				}
				logger.info("Auction id for the product is" + auctionMaster.getAuctionId());
			}
			String subject = "Bid Placed!";
			String message = "You have successfully placed bid on product "+ product.getProductName();
			emailService.sendEmail(bidderCustomer.getEmailId(), message, subject);
			logger.info(" Auction record added successfully");
			logger.info("Bid ends for customer "+customerId);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return -1;
	}

	@Override
	public void deleteAuction(int bidId) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			AuctionTransaction auctionTransaction = (AuctionTransaction) session.get(AuctionTransaction.class, bidId);
			session.delete(auctionTransaction);
			tx.commit();
			logger.info(" Auction record deleted successfully.... ");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public double getBidAmount(int productId) {
		Session session = factory.openSession();
		Transaction tx = null;
		AuctionMaster auctionMaster = null;
		AuctionTransaction auctionTransaction = null;
		List<AuctionTransaction> auctionTransactions = new ArrayList<AuctionTransaction>();
		int finalAuctionId = 0;
		try {
			tx = session.beginTransaction();
			finalAuctionId = getAuctionIdFromProductId(productId);

			auctionTransactions = session.createQuery("FROM AuctionTransaction").list();
			for (Iterator iterator1 = auctionTransactions.iterator(); iterator1.hasNext();) {
				auctionTransaction = (AuctionTransaction) iterator1.next();
				if (auctionTransaction.getAuctionMaster().getAuctionId() == finalAuctionId) {
					return auctionTransaction.getAuctionMaster().getFinalBidPrice();
				}
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	private int getHighestBidAmount(AuctionTransaction auctionTransaction) {
		Session session = factory.openSession();
		int finalAuctionId = 0;
		try {
			auctionTransaction.getBidAmount();
		}catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	public int getAuctionIdFromProductId(int productId) {

		Session session = factory.openSession();
		AuctionMaster auctionMaster = null;
		int finalAuctionId = 0;
		try {
			List<AuctionMaster> auctionMasterList = session
					.createQuery("FROM AuctionMaster AM where AM.productSoldStatus=" + 1).list();

			for (Iterator iterator1 = auctionMasterList.iterator(); iterator1.hasNext();) {
				auctionMaster = (AuctionMaster) iterator1.next();
				Product product = auctionMaster.getProduct();
				if (product.getProductId() == productId) {
					finalAuctionId = auctionMaster.getAuctionId();
					logger.info("Auction id is" + finalAuctionId + " for product id " + productId);
					break;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {	
			session.close();
		}
		return finalAuctionId;
	}
	
	@Override
	public List<AuctionTransaction> getBidDeatailsbyProductId(int productId) {
		logger.info("inside getBidDetailsbyProductId");
		Session session = factory.openSession();
		Transaction tx = null;
		List<AuctionTransaction> results = new ArrayList<AuctionTransaction>();
		try {
			tx = session.beginTransaction();
			int auctionId = getAuctionIdFromProductId(productId);
			
			List<AuctionTransaction> auctionTransaction = session.createQuery("FROM AuctionTransaction").list();
			for (Iterator iterator = auctionTransaction.iterator(); iterator.hasNext();) {
				AuctionTransaction auctionsTransaction = (AuctionTransaction) iterator.next();
				AuctionMaster auctionMaster = auctionsTransaction.getAuctionMaster();
				if(auctionMaster.getAuctionId()==auctionId){
					results.add(auctionsTransaction);
				}
			}
			
			return results;
		}catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}


