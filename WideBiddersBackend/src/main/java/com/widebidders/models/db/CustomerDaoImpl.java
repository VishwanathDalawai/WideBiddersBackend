package com.widebidders.models.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.LoginEntity;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory factory;
	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	public CustomerDaoImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			logger.error("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public List getCustomers() {
		logger.info("Inside Cusromer Dao ");
		Session session = factory.openSession();
		Transaction tx = null;
		List customers = null;
		try {
			tx = session.beginTransaction();
			customers = session.createQuery("FROM Customer ").list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customers;

	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
			logger.info("Added Successfully");
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
		Session session = factory.openSession();
		Transaction tx = null;
		List<Customer> customers = new ArrayList<Customer>();

		try {
			tx = session.beginTransaction();
			logger.info("Inside getCustomerByID hello1");
			customers = session.createQuery("FROM Customer").list();
			logger.info(customers.toString());
			for (Iterator iterator1 = customers.iterator(); iterator1.hasNext();) {
				logger.info("Inside getCustomerByID hello2");
				Customer customer = (Customer) iterator1.next();
				if (customer.getCustomerId()==id) {
					logger.info("Inside getCustomerByID hello3");
					logger.info("Inside getCustomerById Success"+customer.getEmailId());
					return customer;
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

	@Override
	public void deleteCustomer(int id) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, id);
			session.delete(customer);
			tx.commit();
			logger.info("Deleted successfully.... ");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		// TODO Auto-generated method stub

	}

	public Customer loginAuthentication(LoginEntity login) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Customer> customers = new ArrayList<Customer>();

		try {
			tx = session.beginTransaction();
			customers = session.createQuery("FROM Customer").list();
			for (Iterator iterator1 = customers.iterator(); iterator1.hasNext();) {
				Customer customer = (Customer) iterator1.next();
				if ((login.getEmailId().equalsIgnoreCase(customer.getEmailId()))
						&& (login.getPassword().equals(customer.getPassword()))) {
					logger.info("Login Success"+login.getEmailId()+" "+login.getPassword());
					return customer;
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

	public String getMailId(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Customer> customers = new ArrayList<Customer>();

		try {
			tx = session.beginTransaction();
			customers = session.createQuery("FROM Customer").list();
			for (Iterator iterator1 = customers.iterator(); iterator1.hasNext();) {
				Customer customer = (Customer) iterator1.next();
				if ((id==customer.getCustomerId())) {
					logger.info("Get mail id");
					return customer.getEmailId();
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
