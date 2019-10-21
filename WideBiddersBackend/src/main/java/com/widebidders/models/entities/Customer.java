package com.widebidders.models.entities;

public class Customer {

	private String customerName;
	private int phoneNumber;
	private String emailId;
	private int customerId;
	private int userName;
	private int password;
	private String userType;
	private String userStatusActive;
	private String userImage;

	public Customer(String customerName, int phoneNumber, String emailId, int customerId, int userName, int password,
			String userType, String userStatusActive, String userImage) {

		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.userStatusActive = userStatusActive;
		this.userImage = userImage;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getUserName() {
		return userName;
	}

	public void setUserName(int userName) {
		this.userName = userName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
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
