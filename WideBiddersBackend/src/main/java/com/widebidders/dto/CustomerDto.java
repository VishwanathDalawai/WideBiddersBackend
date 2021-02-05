<<<<<<< HEAD
package com.widebidders.dto;

import java.util.Set;

import com.widebidders.models.entities.Customer;

public class CustomerDto {

	private int customerId;
	private String customerName;
	private String phoneNumber;
	private String emailId;
	private String password;
	
	private String userStatusActive;
	private String userImage;
	private Set<ProductDto> products;

	public CustomerDto() {
	}

	public CustomerDto(Customer customer) {
		this.customerName = customer.getCustomerName();
		this.phoneNumber = customer.getPhoneNumber();
		this.emailId = customer.getEmailId();
		this.password = customer.getPassword();
		
		this.userStatusActive = customer.getUserStatusActive();
		this.userImage = customer.getUserImage();
	}

	public CustomerDto(String customerName, String phoneNumber, String emailId, String password, 
			String userStatusActive, String userImage) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
	
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

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}

}
=======
package com.widebidders.dto;

import java.util.Set;

import com.widebidders.models.entities.Customer;

public class CustomerDto {

	private int customerId;
	private String customerName;
	private String phoneNumber;
	private String emailId;
	private String password;
	
	private String userStatusActive;
	private String userImage;
	private Set<ProductDto> products;

	public CustomerDto() {
	}

	public CustomerDto(Customer customer) {
		this.customerName = customer.getCustomerName();
		this.phoneNumber = customer.getPhoneNumber();
		this.emailId = customer.getEmailId();
		this.password = customer.getPassword();
		
		this.userStatusActive = customer.getUserStatusActive();
		this.userImage = customer.getUserImage();
	}

	public CustomerDto(String customerName, String phoneNumber, String emailId, String password, 
			String userStatusActive, String userImage) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
	
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

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}

}
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
