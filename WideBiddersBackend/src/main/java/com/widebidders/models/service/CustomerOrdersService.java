package com.widebidders.models.service;

import java.util.List;

public interface CustomerOrdersService {
	public void addOrder(CustomerOrdersService order);

	public List getOrderById(int id);

	public List getOrders();

	public void deleteOrder(int id);

	public void updateOrderDetails(int id, CustomerOrdersService customer);

}
