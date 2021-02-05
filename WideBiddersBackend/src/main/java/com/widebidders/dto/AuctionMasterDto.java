package com.widebidders.dto;

import java.util.Date;

public class AuctionMasterDto {
	
	private int auctionId;
	private double finalBidPrice;
	private Date dateTime;
	private double startingBidPrice;
	private Date auctionStartDate;
	private Date auctionEndDate;
	private double bidIncrement;
	private String productSoldStatus;
	private String auctionDescription;
	private int customerId;
	private int productId;

	public AuctionMasterDto() {

	}

	public AuctionMasterDto(int customerId, int productId, double finalBidPrice, Date dateTime, double startingBidPrice,
			Date auctionStartDate, Date auctionEndDate, double bidIncrement, String productSoldStatus, String auctionDescription) {
		this.customerId = customerId;
		this.productId = productId;
		this.finalBidPrice = finalBidPrice;
		this.dateTime = dateTime;
		this.startingBidPrice = startingBidPrice;
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
		this.bidIncrement = bidIncrement;
		this.productSoldStatus = productSoldStatus;
		this.auctionDescription = auctionDescription;
	}
	
	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getStartingBidPrice() {
		return startingBidPrice;
	}

	public void setStartingBidPrice(double startingBidPrice) {
		this.startingBidPrice = startingBidPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getFinalBidPrice() {
		return finalBidPrice;
	}

	public void setFinalBidPrice(double finalBidPrice) {
		this.finalBidPrice = finalBidPrice;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getAuctionStartDate() {
		return auctionStartDate;
	}

	public void setAuctionStartDate(Date auctionStartDate) {
		this.auctionStartDate = auctionStartDate;
	}

	public Date getAuctionEndDate() {
		return auctionEndDate;
	}

	public void setAuctionEndDate(Date auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}

	public double getBidIncrement() {
		return bidIncrement;
	}

	public void setBidIncrement(double bidIncrement) {
		this.bidIncrement = bidIncrement;
	}

	public String getproductSoldStatus() {
		return productSoldStatus;
	}

	public void setproductSoldStatus(String productSoldStatus) {
		this.productSoldStatus = productSoldStatus;
	}

	public String getAuctionDescription() {
		return auctionDescription;
	}

	public void setAuctionDescription(String auctionDescription) {
		this.auctionDescription = auctionDescription;
	}

}