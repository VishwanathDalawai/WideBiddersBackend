package com.widebidders.models.db;

import java.util.ArrayList;
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
<<<<<<< HEAD
=======
import com.widebidders.models.entities.Customer;
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
import com.widebidders.models.entities.Product;

@Repository
public class AuctionTransactionDaoImpl implements AuctionTransactionDao {

	private SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(AuctionMasterDaoImpl.class);

	@Autowired
	public CustomerDaoImpl customerDaoImpl;

	@Autowired
	public AuctionMasterDaoImpl auctionMasterDaoImpl;

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
<<<<<<< HEAD
	public void addBid(AuctionTransaction bid, int productId) {
=======
	public void addBid(AuctionTransaction bid, int productId, int customerId) {
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
		Session session = factory.openSession();
		Transaction tx = null;
		AuctionMaster auctionMaster = null;

		try {
			tx = session.beginTransaction();
<<<<<<< HEAD
			String sql = "SELECT * from AuctionMaster where auctionId in (SELECT max(auctionId) FROM AuctionMaster group by productId having productId ="
					+ productId + ")";
			// String sql = "SELECT * FROM AuctionMaster WHERE productId =
			// "+productId+"having MAX(auctionId)";
			// String sql = "SELECT MAX(auction.auctionId) FROM AuctionMaster
			// auction WHERE productId = "+productId ;
			Query query = session.createQuery(sql);
			AuctionMaster auctionMaster = (AuctionMaster) query.uniqueResult();
			logger.info("Highest auction id for the product is" + auctionMaster.getAuctionId());
			bid.setAuctionMaster(auctionMaster);
=======

			List<AuctionMaster> auctionMasterList = session.createQuery("FROM AuctionMaster AM where AM.productSoldStatus=" + 1).list();

			for (Iterator iterator1 = auctionMasterList.iterator(); iterator1.hasNext();) {
				auctionMaster = (AuctionMaster) iterator1.next();
				Product product = auctionMaster.getProduct();
				if (product.getProductId() == productId) {
					if(auctionMaster.getFinalBidPrice()<bid.getBidAmount()){
						logger.info("Final Bid Price is "+auctionMaster.getFinalBidPrice()+" "+"Bid amount id "+bid.getBidAmount());
						auctionMaster.setFinalBidPrice(bid.getBidAmount());
					}
					bid.setAuctionMaster(auctionMaster);
					break;
				}
				
				logger.info("Auction id for the product is" + auctionMaster.getAuctionId());
			}
			Customer bidderCustomer = customerDaoImpl.getCustomerById(customerId);
			logger.info("The bidder customer is" + bidderCustomer.getCustomerId());

			bid.setBidderCustomer(bidderCustomer);
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
			session.save(bid);
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

<<<<<<< HEAD
	@Override
	public AuctionTransaction getBidDeatailsbyProductId(int productId) {
		logger.info("inside getBidDetailsbyProductId");
		Session session = factory.openSession();
		Transaction tx = null;
		List<AuctionTransaction> results = new ArrayList<AuctionTransaction>();

		try {
			logger.info("inside try"+productId);
			tx = session.beginTransaction();
			int auctionId = getAuctionIdFromProductId(productId);
			System.out.println("Auction id"+auctionId);
			
			List<AuctionTransaction> auctionTransaction = session.createQuery("FROM AuctionTransaction").list();
			for (Iterator iterator = auctionTransaction.iterator(); iterator.hasNext();) {
				logger.info("inside for 2");
				AuctionTransaction auctionsTransaction = (AuctionTransaction) iterator.next();
				AuctionMaster auctionMaster = auctionsTransaction.getAuctionMaster();
				if(auctionMaster.getAuctionId()==auctionId){
					return auctionsTransaction;
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

}
=======
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
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
