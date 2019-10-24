package com.widebidders.models.entities;

import java.util.Set;

public class Customer {
	private int customerId;
	private String customerName;
	private String phoneNumber;
	private String userEmailId;
	private String userPassword;
	private String userType;
	private String userStatusActive;
	private String userImage;
	private Set<Product> products;

	public Customer(){
	} 
	
	public Customer(String customerName, String phoneNumber, String userEmailId, String userPassword,
			String userType, String userStatusActive, String userImage) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.userEmailId = userEmailId;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userStatusActive = userStatusActive;
		this.userImage = userImage;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserStatusActive() {
		return userStatusActive;
	}

	public void setUserStatusActive(String userStatusActive) {
		this.userStatusActive = userStatusActive;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
