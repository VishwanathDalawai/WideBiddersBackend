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
public class AuctionMasterDaoImpl implements AuctionMasterDao {

	private SessionFactory factory;

	@Autowired
	public AuctionTransactionDaoImpl auctionTransactionDaoImpl;

	@Autowired
	public EmailService emailService;

	private static final Logger logger = LoggerFactory.getLogger(AuctionMasterDaoImpl.class);

	public AuctionMasterDaoImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			logger.error("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public void addAuction(AuctionMaster auctionMaster, Product product, Customer customer) {
		Session session = factory.openSession();
		Transaction tx = null;
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		logger.info("Adding auction transaction entity");
		try {
			tx = session.beginTransaction();
			auctionMaster.setProduct(product);
			auctionMaster.setCustomer(customer);
			auctionMaster.setAuctionStartDate(currentDate);
			calendar.add(Calendar.DATE, 7);
			Date endDate = calendar.getTime();
			auctionMaster.setAuctionEndDate(endDate);
			session.save(auctionMaster);
			String subject = "Product added!";
			String message = "You added the product successfully, Woooo....Bidding for your product "
					+ product.getProductName() + "starts";
			emailService.sendEmail(customer.getEmailId(), message, subject);
			tx.commit();
			logger.info(" Auction record added successfully");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * Can be used for admin activities
	 */

	@Override
	public void deleteAuction(int auctionId) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			AuctionMaster auctionMaster = (AuctionMaster) session.get(AuctionMaster.class, auctionId);
			session.delete(auctionMaster);
			tx.commit();
			logger.info(" Auction record deleted successfully");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/**
	 * Can be used in future for admin activities
	 */
	@Override
	public void updateAuction(int auctionId, AuctionMaster auctionRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public List getAuction() {
		Session session = factory.openSession();
		Transaction tx = null;
		List auction = null;
		logger.info("Getting all auctions");
		try {
			tx = session.beginTransaction();
			auction = session.createQuery("FROM AuctionMaster").list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return auction;
	}

	/**
	 * Get auction Id using Auction Id
	 */
	@Override
	public List<AuctionMaster> getAuctionById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<AuctionMaster> results = new ArrayList<AuctionMaster>();
		logger.info("Getting auction master for auction id= " + id);
		try {
			tx = session.beginTransaction();
			String hql = "FROM AuctionMaster WHERE auctionId = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);

			List<AuctionMaster> list = query.list();
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
	public void getBidDetailsById(int productId) {
		Session session = factory.openSession();
		Transaction tx = null;
		AuctionMaster auctionMaster = null;
		List customer = null;
		Double finalAmountAuctionMaster = 0.0;
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		int customerId = 0;
		logger.info("Getting bid details for product id " + productId + " to deliver");

		try {
			tx = session.beginTransaction();
			String hql = "FROM AuctionMaster";
			Query query = session.createQuery(hql);

			List<AuctionMaster> auctionMasterList = query.list();
			for (Iterator iterator1 = auctionMasterList.iterator(); iterator1.hasNext();) {
				auctionMaster = (AuctionMaster) iterator1.next();
				Product product = auctionMaster.getProduct();
				if (product.getProductId() == productId) {
					finalAmountAuctionMaster = auctionMaster.getFinalBidPrice();
					if (finalAmountAuctionMaster == auctionMaster.getStartingBidPrice()) {
						// no one has bid
						logger.info("No one has bid");
						auctionMaster.setAuctionStartDate(currentDate);
						calendar.add(Calendar.DATE, 7);
						Date endDate = calendar.getTime();
						auctionMaster.setAuctionEndDate(endDate);
					} else {
						// get bidder customer from auction transaction
						logger.info("Getting bid customer");
						List auctionTransactions = auctionTransactionDaoImpl.getAllBids();
						for (Iterator iterator2 = auctionTransactions.iterator(); iterator1.hasNext();) {
							AuctionTransaction auctionTransaction = (AuctionTransaction) iterator2.next();
							System.out.println("au "+auctionTransaction.getAuctionMaster().getAuctionId()+" "+auctionMaster.getAuctionId());
							if (auctionTransaction.getAuctionMaster().getAuctionId()==auctionMaster.getAuctionId()) {
								customerId = auctionTransaction.getBidderCustomer().getCustomerId();
								product.setApprovalStatus("0");
								auctionMaster.setProductSoldStatus("0");
								logger.info("Yoooooooo...." + customerId + " won the bid for the product " + productId);
							}
						}
					}
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return;
	}

	@Override
	public AuctionMaster getBidDates(int productId) {
		Session session = factory.openSession();
		Transaction tx = null;
		AuctionMaster auctionMaster = null;
		logger.info("Getting bid dates");
		try {
			tx = session.beginTransaction();
			String hql = "FROM AuctionMaster";
			Query query = session.createQuery(hql);

			List<AuctionMaster> auctionMasterList = query.list();
			for (Iterator iterator1 = auctionMasterList.iterator(); iterator1.hasNext();) {
				auctionMaster = (AuctionMaster) iterator1.next();
				Product product = auctionMaster.getProduct();
				if (product.getProductId() == productId) {
					return auctionMaster;
				}
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
