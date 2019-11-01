package com.widebidders.models.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.AuctionTransaction;

@Repository
public class AuctionTransactionDaoImpl implements AuctionTransactionDao{

	private SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(AuctionMasterDaoImpl.class);

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
			System.out.println("Bid ID is " + id);
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
	public void addBid(AuctionTransaction bid) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
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
}
