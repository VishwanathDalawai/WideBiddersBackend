package com.widebidders.models.entities;

import java.util.Set;

import com.widebidders.dto.CustomerDto;

public class Customer {
	private int customerId;
	private String customerName;
	private String phoneNumber;
	private String emailId;
	private String password;
	private String userType;
	private String userStatusActive;
	private String userImage;

	public Customer(){
	} 
	
	public Customer(String customerName, String phoneNumber, String emailId, String password,
			String userType, String userStatusActive, String userImage) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
		this.userType = userType;
		this.userStatusActive = userStatusActive;
		this.userImage = userImage;
	}
	public Customer(CustomerDto customer) {
		this.customerName = customer.getCustomerName();
		this.phoneNumber = customer.getPhoneNumber();
		this.emailId = customer.getEmailId();
		this.password = customer.getPassword();
		this.userType = customer.getUserType();
		this.userStatusActive = customer.getUserStatusActive();
		this.userImage = customer.getUserImage();
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
}
