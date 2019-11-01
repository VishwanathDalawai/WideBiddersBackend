package com.widebidders.models.entities;

public class AuctionTransaction {

	private int bidId;
	private Customer customer;
	private AuctionMaster auctionMaster;
	private double bidAmount;
	private String dateTime;
	
	public AuctionTransaction() {
	}
	
	public AuctionTransaction(Customer customer, AuctionMaster auctionMaster, double bidAmount, String dateTime){
		this.customer = customer;
		this.auctionMaster = auctionMaster;
		this.bidAmount = bidAmount;
		this.dateTime = dateTime;
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AuctionMaster getAuctionMaster() {
		return auctionMaster;
	}

	public void setAuctionMaster(AuctionMaster auctionMaster) {
		this.auctionMaster = auctionMaster;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}	
}
