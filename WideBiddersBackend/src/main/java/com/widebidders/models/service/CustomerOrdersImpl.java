package com.widebidders.models.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.CustomerOrderDaoImpl;

@Service
public class CustomerOrdersImpl implements CustomerOrdersService {
	private SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(CustomerOrderDaoImpl.class);
	@Autowired
	private CustomerOrderDaoImpl orderDboImpl;

	@Override
	public void addOrder(CustomerOrdersService order) {
		orderDboImpl.addOrder(order);

	}

	@Override
	public List getOrderById(int id) {

		return orderDboImpl.getOrderById(id);
	}

	@Override
	public List getOrders() {

		return orderDboImpl.getOrders();
	}

	@Override
	public void deleteOrder(int id) {
		orderDboImpl.deleteOrder(id);
	}

	@Override
	public void updateOrderDetails(int id, CustomerOrdersService order) {
		orderDboImpl.updateOrderDetails(id, order);

	}

}
