package com.widebidders.models.service;

import java.util.HashMap; 
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.CustomerDaoImpl;
import com.widebidders.models.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	Map<Integer, Customer> CustomerMap = new HashMap<Integer, Customer>();
	static int productId = 10;

	@Autowired(required=true)
    private CustomerDaoImpl customerDboImpl;
	
	public CustomerServiceImpl() {
		CustomerMap.put(1, new Customer("anu", "636", "anugmailcom", "anu123", "user", "yes", "img1"));
	}

	public Map<Integer, Customer> getCustomers() {
		logger.info("Inside Customer Service get customers");
		return customerDboImpl.getCustomers();
	}
	
	public void addCustomer(int id, Customer customer) {
		logger.error("Inside add product Service class"+customer);
		customerDboImpl.addCustomer(id, customer); 
	}
	
	public Customer getCustomerById(int id) {
		return customerDboImpl.getCustomerById(id);
	}

	public void deleteCustomer(int id) {
		customerDboImpl.deleteCustomer(id);
	}

	public void updateCustomer(int id, Customer customer) {
		customerDboImpl.updateCustomer(id, customer);
	}
}
