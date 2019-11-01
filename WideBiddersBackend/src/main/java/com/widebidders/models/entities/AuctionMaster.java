package com.widebidders.models.entities;

import java.util.Date;

import com.widebidders.dto.AuctionMasterDto;

public class AuctionMaster {
	private int auctionId;
	private float finalBidPrice;
	private Date dateTime;
	private float minBidPrice;
	private Date auctionStartDate;
	private Date auctionEndDate;
	private float bidIncrement;
	private String productSoldStatus;
	private String auctionDescription;
	private Customer customer; 
	private Product product;

	public AuctionMaster() {
	}

	public AuctionMaster(Customer customer, Product product, float finalBidPrice, Date dateTime, float minBidPrice,
			Date auctionStartDate, Date auctionEndDate, float bidIncrement, String productSoldStatus, String auctionDescription) {
		this.customer = customer;
		this.product = product;
		this.finalBidPrice = finalBidPrice;
		this.dateTime = dateTime;
		this.minBidPrice = minBidPrice;
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
		this.bidIncrement = bidIncrement;
		this.productSoldStatus = productSoldStatus;
		this.auctionDescription = auctionDescription;
	}
	
	public AuctionMaster(AuctionMasterDto auctionMaster)
	{
		this.customer =auctionMaster.getCustomer() ;
		this.product = auctionMaster.getProduct();
		this.finalBidPrice = auctionMaster.getFinalBidPrice();
		this.dateTime = auctionMaster.getDateTime();
		this.minBidPrice = auctionMaster.getMinBidPrice();
		this.auctionStartDate = auctionMaster.getAuctionStartDate();
		this.auctionEndDate = auctionMaster.getAuctionEndDate();
		this.bidIncrement =auctionMaster.getBidIncrement();
		this.productSoldStatus =auctionMaster.getStatus();
		this.auctionDescription = auctionMaster.getAuctionDescription();
	}
	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public float getFinalBidPrice() {
		return finalBidPrice;
	}

	public void setFinalBidPrice(float finalBidPrice) {
		this.finalBidPrice = finalBidPrice;
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

	public float getBidIncrement() {
		return bidIncrement;
	}

	public void setBidIncrement(float bidIncrement) {
		this.bidIncrement = bidIncrement;
	}

	public String getProductSoldStatus() {
		return productSoldStatus;
	}

	public void setProductSoldStatus(String productSoldStatus) {
		this.productSoldStatus = productSoldStatus;
	}

	public String getAuctionDescription() {
		return auctionDescription;
	}

	public void setAuctionDescription(String auctionDescription) {
		this.auctionDescription = auctionDescription;
	}
}	