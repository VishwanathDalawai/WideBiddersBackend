package com.widebidders.models.entities;

import java.util.Date;

public class CustomerOrders {

	
		private int	orderId;
		private int customerId;
		private int productId;
		private double highestBidAmount;
		private Date dateOrderplaced;
		private Date dateOrderpaid;
		private String orderStatus;
		
		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

	

		public CustomerOrders(int customerId, int productId, double highestBidAmount, Date dateOrderplaced,
				Date dateOrderpaid, String orderStatus, String paymentMode,int	orderId) {
			this.customerId = customerId;
			this.productId = productId;
			this.highestBidAmount = highestBidAmount;
			this.dateOrderplaced = dateOrderplaced;
			this.dateOrderpaid = dateOrderpaid;
			this.orderStatus = orderStatus;
			this.paymentMode = paymentMode;
			this.orderId = orderId;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public double getHighestBidAmount() {
			return highestBidAmount;
		}

		public void setHighestBidAmount(double highestBidAmount) {
			this.highestBidAmount = highestBidAmount;
		}

		public Date getDateOrderplaced() {
			return dateOrderplaced;
		}

		public void setDateOrderplaced(Date dateOrderplaced) {
			this.dateOrderplaced = dateOrderplaced;
		}

		public Date getDateOrderpaid() {
			return dateOrderpaid;
		}

		public void setDateOrderpaid(Date dateOrderpaid) {
			this.dateOrderpaid = dateOrderpaid;
		}

		public String getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}

		public String getPaymentMode() {
			return paymentMode;
		}

		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}

		private String paymentMode;

	}


