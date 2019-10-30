package com.widebidders.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.LoginEntity;
import com.widebidders.models.service.CustomerServiceImpl;

@RestController
public class CustomerController {
		
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	public CustomerServiceImpl customerService;

	public CustomerController() {
		logger.info("CustomerContoller is called");
	}
	
	@RequestMapping(value = "/customer")
	public List getCustomers() {
		logger.info("Inside get customers of CustomerController");
		return customerService.getCustomers();
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
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
	public int login(@RequestBody LoginEntity login, HttpSession httpSession) {
		Customer customer = customerService.loginAuthentication(login);	//returns null if customerId is not found, else returns customer entity
		if(customer == null){		
			return -1;
		}
		logger.info(customer.getCustomerName());
//		httpSession.setMaxInactiveInterval(0);
//		httpSession.setAttribute("customer", customer);
		
		logger.info("CustomerId is "+ customer);
		return customer.getCustomerId();
	}
}
