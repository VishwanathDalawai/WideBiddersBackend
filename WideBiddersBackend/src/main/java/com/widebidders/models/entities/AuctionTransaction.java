package com.widebidders.models.entities;

import com.widebidders.dto.AuctionTransactionDto;
import com.widebidders.models.db.AuctionTransactionDao;

public class AuctionTransaction {

	private int bidId;
	private Customer bidderCustomer;
	private AuctionMaster auctionMaster;
	private double bidAmount;
	private String dateTime;
	
	public AuctionTransaction() {
	}
	
	public AuctionTransaction(Customer bidderCustomer, AuctionMaster auctionMaster, double bidAmount, String dateTime){
		this.bidderCustomer = bidderCustomer;
		this.auctionMaster = auctionMaster;
		this.bidAmount = bidAmount;
		this.dateTime = dateTime;
	}

	public AuctionTransaction(AuctionTransactionDto auctionTransactionDto){
		this.bidderCustomer = auctionTransactionDto.getBidderCustomer();
		this.auctionMaster = auctionTransactionDto.getAuctionMaster();
		this.bidAmount = auctionTransactionDto.getBidAmount();
		this.dateTime = auctionTransactionDto.getDateTime();
	}
	
	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	
	public Customer getBidderCustomer() {
		return bidderCustomer;
	}

	public void setBidderCustomer(Customer bidderCustomer) {
		this.bidderCustomer = bidderCustomer;
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
