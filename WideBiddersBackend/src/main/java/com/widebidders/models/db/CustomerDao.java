package com.widebidders.models.db;

import java.util.List;
import java.util.Map;

import com.widebidders.models.entities.Customer;

public interface CustomerDao {
	public List getCustomers();
	public void addCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public void deleteCustomer(int id);
	public void updateCustomer(int id, Customer customer);
}
