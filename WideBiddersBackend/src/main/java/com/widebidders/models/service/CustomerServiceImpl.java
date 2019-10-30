package com.widebidders.models.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.CustomerDaoImpl;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.LoginEntity;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired(required=true)
    private CustomerDaoImpl customerDboImpl;
	
	public CustomerServiceImpl() {
	}

	@Override
	public List getCustomers() {
		logger.info("Inside Customer Service get customers");
		return customerDboImpl.getCustomers();
	}
	
	@Override
	public void addCustomer(Customer customer) {
		logger.error("Inside add Customer Service class"+customer);
		customerDboImpl.addCustomer(customer); 
	}
	
	@Override
	public Customer getCustomerById(int id) {
		return customerDboImpl.getCustomerById(id);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDboImpl.deleteCustomer(id);
	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		customerDboImpl.updateCustomer(id, customer);
	}

	@Override
	public Customer loginAuthentication(LoginEntity login) {
		return customerDboImpl.loginAuthentication(login);
	}

	public String getMailId(int id) {
		return customerDboImpl.getMailId(id);
	}	
}
