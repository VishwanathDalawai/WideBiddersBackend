package com.widebidders.models.entities;

public class SoldProducts {

	private int customerId;
	private int productId;
	private int finalPrice;

	public SoldProducts() {

	}

	public SoldProducts(int customerId, int productId, int finalPrice) {
		this.customerId = customerId;
		this.productId = productId;
		this.finalPrice = finalPrice;
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

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

}
