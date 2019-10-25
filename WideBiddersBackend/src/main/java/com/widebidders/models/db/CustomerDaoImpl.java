package com.widebidders.models.db;

import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.widebidders.models.entities.Customer;

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
	public Map<Integer, Customer> getCustomers() {
		logger.info("Inside Cusromer Dao ");
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		// TODO Auto-generated method stub

	}

}
