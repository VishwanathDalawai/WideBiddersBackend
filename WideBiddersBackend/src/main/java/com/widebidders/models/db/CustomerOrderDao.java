package com.widebidders.models.db;

import java.util.List;

import com.widebidders.models.service.CustomerOrdersService;

public interface CustomerOrderDao {
	public void addOrder(CustomerOrdersService order);

	public List getOrderById(int id);

	public List getOrders();

	public void deleteOrder(int id);

	public void updateOrderDetails(int id, CustomerOrdersService order);

}
