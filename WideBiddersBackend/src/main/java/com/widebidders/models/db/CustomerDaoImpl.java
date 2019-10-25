package com.widebidders.models.db;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory factory;
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	public CustomerDaoImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public List getCustomers() {
		logger.info("Inside Cusromer Dao ");
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(int id) {
		 Session session = factory.openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         Customer customer = (Customer)session.get(Customer.class, id); 
	         session.delete(customer); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		// TODO Auto-generated method stub

	}

}
