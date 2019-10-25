package com.widebidders.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.widebidders.models.db.CustomerDaoImpl;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.LoginEntity;
import com.widebidders.models.service.CustomerService;
import com.widebidders.models.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	static int idIncreamentForCustomerId = 10;
	// private static final Logger logger =
	// LoggerFactory.getLogger(ProductController.class);

	@Autowired
	public CustomerServiceImpl customerService;

	@RequestMapping(value = "/customer")
	public List getCustomers() {
		logger.info("Inside get customers of CustomerController");
		return customerService.getCustomers();
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		idIncreamentForCustomerId++;
		customerService.addCustomer(customer);
		customer.setCustomerId(idIncreamentForCustomerId);
	}

	@RequestMapping(value = "/customerId/{id}")
	public List getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}

	@RequestMapping(value = "/deletecustomer/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
	}

	@RequestMapping(value = "/customerUpdate/{id}", method = RequestMethod.PUT)
	public void updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		customerService.updateCustomer(id, customer);
	}

	@RequestMapping(value = "/customerLogin", method = RequestMethod.POST)
	public boolean login(@RequestBody LoginEntity login) {
		return customerService.loginAuthentication(login);

	}
}
