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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.LoginEntity;
import com.widebidders.models.service.EmailService;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory factory;
	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Autowired
	public EmailService emailService;
	
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

	private boolean isUserExists(Customer customer) {
		Session session = factory.openSession();
		List<Customer> customers = session.createQuery("FROM Customer").list();
		for (Iterator iterator1 = customers.iterator(); iterator1.hasNext();) {
			Customer existingCustomer = (Customer) iterator1.next();
			if (customer.getEmailId().equals(existingCustomer.getEmailId())) {
				System.out.println("Already exists");
				return true;
			}
		}
		return false;
	}

	@Override
	public int addCustomer(Customer customer) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Customer> customers = new ArrayList<Customer>();

		if (isUserExists(customer))
			return -1;

		try {
			tx = session.beginTransaction();
			System.out.println("Saving customer");
			session.save(customer);
			tx.commit();
			String subject = "Welcome "+customer.getCustomerName();
			String message = "Thank you for registering on website Widebidders. We welcome you";
			emailService.sendEmail(customer.getEmailId(), message, subject);
		} catch(HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

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
				if (customer.getCustomerId() == id) {
					logger.info("Inside getCustomerByID hello3");
					logger.info("Inside getCustomerById Success" + customer.getEmailId());
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
	public void updateCustomer(Customer customer) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		 
		try {
			tx = session.beginTransaction();
			Customer previousCustomer = (Customer) session.get(Customer.class, customer.getCustomerId());
		
			previousCustomer.setCustomerName(customer.getCustomerName());
			previousCustomer.setUserImage(customer.getUserImage());
			
			session.evict(previousCustomer);
			session.update(customer);
			System.out.println(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		
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
					logger.info("Login Success" + login.getEmailId() + " " + login.getPassword());
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
				if ((id == customer.getCustomerId())) {
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

	public String getCustomerByEmail(String email) {
		logger.info("Get mail id");
		Session session = factory.openSession();
		Transaction tx = null;
		List<Customer> customers = new ArrayList<Customer>();

		try {
			tx = session.beginTransaction();
			customers = session.createQuery("FROM Customer").list();
			for (Iterator iterator1 = customers.iterator(); iterator1.hasNext();) {
				Customer customer = (Customer) iterator1.next();
				System.out.println(customer.getEmailId());
				System.out.println(email);
				if ((email.equals(customer.getEmailId()))) {
				System.out.println(customer.getCustomerName());
					return customer.getCustomerName();
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