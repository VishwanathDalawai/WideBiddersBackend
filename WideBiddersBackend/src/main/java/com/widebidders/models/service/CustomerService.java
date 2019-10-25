package com.widebidders.models.service;

import java.util.List;
import java.util.Map;

import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.LoginEntity;
  
public interface CustomerService {
	public List getCustomers();
	public void addCustomer(Customer customer);
	public List getCustomerById(int id);
	public void deleteCustomer(int id);
	public void updateCustomer(int id, Customer customer);
	public boolean loginAuthentication(LoginEntity login); 
	
}