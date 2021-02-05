<<<<<<< HEAD
package com.widebidders.models.entities;

import java.util.Date;

import com.widebidders.dto.AuctionMasterDto;

public class AuctionMaster {
	private int auctionId;
	private double finalBidPrice;
	private Date dateTime;
	private double startingBidPrice;
	private Date auctionStartDate;
	private Date auctionEndDate;
	private double bidIncrement;
	private String productSoldStatus;
	private String auctionDescription;
	private Customer customer; 
	private Product product;

	public AuctionMaster() {
	}

	public AuctionMaster(Customer customer, Product product, double finalBidPrice, Date dateTime, double startingBidPrice,
			Date auctionStartDate, Date auctionEndDate, double bidIncrement, String productSoldStatus, String auctionDescription) {
		this.customer = customer;
		this.product = product;
		this.finalBidPrice = finalBidPrice;
		this.dateTime = dateTime;
		this.startingBidPrice = startingBidPrice;
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
		this.bidIncrement = bidIncrement;
		this.productSoldStatus = productSoldStatus;
		this.auctionDescription = auctionDescription;
	}
	
	public AuctionMaster(AuctionMasterDto auctionMaster)
	{
		this.finalBidPrice = auctionMaster.getFinalBidPrice();
		this.dateTime = auctionMaster.getDateTime();
		this.startingBidPrice = auctionMaster.getStartingBidPrice();
		this.auctionStartDate = auctionMaster.getAuctionStartDate();
		this.auctionEndDate = auctionMaster.getAuctionEndDate();
		this.bidIncrement =auctionMaster.getBidIncrement();
		this.productSoldStatus =auctionMaster.getproductSoldStatus();
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

	public double getStartingBidPrice() {
		return startingBidPrice;
	}

	public void setStartingBidPrice(double startingBidPrice) {
		this.startingBidPrice = startingBidPrice;
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
=======
package com.widebidders.models.entities;

import java.util.Date;

import com.widebidders.dto.AuctionMasterDto;

public class AuctionMaster {
	private int auctionId;
	private double finalBidPrice;
	private Date dateTime;
	private double startingBidPrice;
	private Date auctionStartDate;
	private Date auctionEndDate;
	private double bidIncrement;
	private String productSoldStatus;
	private String auctionDescription;
	private Customer customer; 
	private Product product;

	public AuctionMaster() {
	}

	public AuctionMaster(Customer customer, Product product, double finalBidPrice, Date dateTime, double startingBidPrice,
			Date auctionStartDate, Date auctionEndDate, double bidIncrement, String productSoldStatus, String auctionDescription) {
		this.customer = customer;
		this.product = product;
		this.finalBidPrice = finalBidPrice;
		this.dateTime = dateTime;
		this.startingBidPrice = startingBidPrice;
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
		this.bidIncrement = bidIncrement;
		this.productSoldStatus = productSoldStatus;
		this.auctionDescription = auctionDescription;
	}
	
	public AuctionMaster(AuctionMasterDto auctionMaster)
	{
		this.finalBidPrice = auctionMaster.getFinalBidPrice();
		this.dateTime = auctionMaster.getDateTime();
		this.startingBidPrice = auctionMaster.getStartingBidPrice();
		this.auctionStartDate = auctionMaster.getAuctionStartDate();
		this.auctionEndDate = auctionMaster.getAuctionEndDate();
		this.bidIncrement =auctionMaster.getBidIncrement();
		this.productSoldStatus =auctionMaster.getproductSoldStatus();
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

	public double getStartingBidPrice() {
		return startingBidPrice;
	}

	public void setStartingBidPrice(double startingBidPrice) {
		this.startingBidPrice = startingBidPrice;
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
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
}