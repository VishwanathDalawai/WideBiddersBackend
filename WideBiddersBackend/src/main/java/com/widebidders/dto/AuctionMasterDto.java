package com.widebidders.dto;

import java.util.Date;

public class AuctionMasterDto {

	private int customerId;
	private int productId;
	private float bidPrice;
	private Date dateTime;
	private float minBidPrice;
	private Date auctionStratDate;
	private Date auctionEndDate;
	private float bidIncrement;
	private String status;
	private String auctionDescription;

	public AuctionMasterDto() {

	}

	public AuctionMasterDto(int customerId, int productId, float bidPrice, Date dateTime, float minBidPrice,
			Date auctionStratDate, Date auctionEndDate, float bidIncrement, String status, String auctionDescription) {

		this.customerId = customerId;
		this.productId = productId;
		this.bidPrice = bidPrice;
		this.dateTime = dateTime;
		this.minBidPrice = minBidPrice;
		this.auctionStratDate = auctionStratDate;
		this.auctionEndDate = auctionEndDate;
		this.bidIncrement = bidIncrement;
		this.status = status;
		this.auctionDescription = auctionDescription;
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

	public float getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(float bidPrice) {
		this.bidPrice = bidPrice;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public float getMinBidPrice() {
		return minBidPrice;
	}

	public void setMinBidPrice(float minBidPrice) {
		this.minBidPrice = minBidPrice;
	}

	public Date getAuctionStratDate() {
		return auctionStratDate;
	}

	public void setAuctionStratDate(Date auctionStratDate) {
		this.auctionStratDate = auctionStratDate;
	}

	public Date getAuctionEndDate() {
		return auctionEndDate;
	}

	public void setAuctionEndDate(Date auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}

	public float getBidIncrement() {
		return bidIncrement;
	}

	public void setBidIncrement(float bidIncrement) {
		this.bidIncrement = bidIncrement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuctionDescription() {
		return auctionDescription;
	}

	public void setAuctionDescription(String auctionDescription) {
		this.auctionDescription = auctionDescription;
	}

}
