package com.widebidders.models.service;

import java.util.List;

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

	@Autowired(required = true)
	private CustomerDaoImpl customerDboImpl;

	public CustomerServiceImpl() {
	}

	@Override
	public List getCustomers() {
		return customerDboImpl.getCustomers();
	}

	@Override
	public int addCustomer(Customer customer) {
		return customerDboImpl.addCustomer(customer);
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
	public void updateCustomer(Customer customer) {
		customerDboImpl.updateCustomer(customer);
	}

	@Override
	public Customer loginAuthentication(LoginEntity login) {
		return customerDboImpl.loginAuthentication(login);
	}

	@Override
	public String getMailId(int id) {
		return customerDboImpl.getMailId(id);
	}
	
	@Override
	public String getCustomerByEmail(String email) {
		return customerDboImpl.getCustomerByEmail(email);
	}
}