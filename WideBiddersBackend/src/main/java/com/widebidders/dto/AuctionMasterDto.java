package com.widebidders.dto;

import java.util.Date;

import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;

public class AuctionMasterDto {
	
	private int auctionId;
	private float finalBidPrice;
	private Date dateTime;
	private float minBidPrice;
	private Date auctionStartDate;
	private Date auctionEndDate;
	private float bidIncrement;
	private String status;
	private String auctionDescription;
	private Customer customer;
	private Product product;

	public AuctionMasterDto() {

	}

	public AuctionMasterDto(Customer customer, Product product, float finalBidPrice, Date dateTime, float minBidPrice,
			Date auctionStartDate, Date auctionEndDate, float bidIncrement, String status, String auctionDescription) {
		this.customer = customer;
		this.product = product;
		this.finalBidPrice = finalBidPrice;
		this.dateTime = dateTime;
		this.minBidPrice = minBidPrice;
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
		this.bidIncrement = bidIncrement;
		this.status = status;
		this.auctionDescription = auctionDescription;
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
