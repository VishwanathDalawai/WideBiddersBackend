package com.widebidders.models.entities;

public class LoggedInUsers {
	private static int noOfUserLoggedIn;
	private static int customerId[];
	
	public LoggedInUsers() {
	}
	
	public LoggedInUsers(int noOfUserLoggedIn, int customerId[] ){
		this.noOfUserLoggedIn = noOfUserLoggedIn;
		this.customerId = customerId;
	}

	public int getNoOfUserLoggedIn() {
		return noOfUserLoggedIn;
	}

	public void setNoOfUserLoggedIn(int noOfUserLoggedIn) {
		this.noOfUserLoggedIn = noOfUserLoggedIn;
	}

	public int[] getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int[] customerId) {
		this.customerId = customerId;
	}

}
