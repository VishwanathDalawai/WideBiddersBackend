package com.widebidders.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.widebidders.models.entities.LoggedInUsers;
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
		return customerService.getCustomers();
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public int addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@RequestMapping(value = "/customerId/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@RequestMapping(value = "/customerEmail/{email}")
	public  Map<String, String>  getCustomerByEmail(@PathVariable String email) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("UserName",customerService.getCustomerByEmail(email));
		return map;
	}

	@RequestMapping(value = "/deletecustomer/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
	}

	@RequestMapping(value = "/customerUpdate/{id}", method = RequestMethod.PUT)
	public void updateCustomer( @RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

	@RequestMapping(value = "/customerLogin", method = RequestMethod.POST)
	public int login(@RequestBody LoginEntity login, HttpSession httpSession) {
		Customer customer = customerService.loginAuthentication(login);	//returns null if customerId is not found, else returns customer entity
		if(customer == null){		
			return -1;
		}
		LoggedInUsers loggedInUsers = new LoggedInUsers();
		int noOfUsersLoggedIn= loggedInUsers.getNoOfUserLoggedIn();
		loggedInUsers.setNoOfUserLoggedIn(++noOfUsersLoggedIn);
		
		int[] customerId = loggedInUsers.getCustomerId();
		return customer.getCustomerId();
	}
	
	@RequestMapping(value = "/getCustEmail", method = RequestMethod.POST)
	public Map<String, String> getMailID(@RequestBody int id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("MailID",customerService.getMailId(id));
		return map;
	}
}
