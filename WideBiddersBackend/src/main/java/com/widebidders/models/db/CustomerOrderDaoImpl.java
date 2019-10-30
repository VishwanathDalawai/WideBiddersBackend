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

import com.widebidders.models.entities.CustomerOrders;
import com.widebidders.models.service.CustomerOrdersService;

@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	private SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(CustomerOrderDaoImpl.class);
	public CustomerOrderDaoImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			logger.error("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public void addOrder(CustomerOrdersService order) {
	
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(order);
			tx.commit();
			logger.info(" Order Added successfully");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public List getOrderById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<CustomerOrders> results = new ArrayList<CustomerOrders>();
		try {
			tx = session.beginTransaction();
			String hql = "FROM CustomerOrders WHERE orderId = :id";
			System.out.println("ID is " + id);
			Query query = session.createQuery(hql);
			query.setParameter("id", id);

			List<CustomerOrders> list = query.list();
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
	public List getOrders() {
		Session session = factory.openSession();
		Transaction tx = null;
		List orders = null;
		try {
			tx = session.beginTransaction();
			orders = session.createQuery("FROM CustomerOrders ").list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return orders;
	}

	@Override
	public void deleteOrder(int id) {
		

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			CustomerOrdersService order = (CustomerOrdersService) session.get(CustomerOrdersService.class, id);
			session.delete(order);
			tx.commit();
			logger.info(" order deleted successfully");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}

	}

	@Override
	public void updateOrderDetails(int id, CustomerOrdersService order) {
		// TODO Auto-generated method stub

	}

}
