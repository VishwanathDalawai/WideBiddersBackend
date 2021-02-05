<<<<<<< HEAD
package com.widebidders.dto;

import java.util.Date;

import com.widebidders.models.entities.AuctionMaster;

public class AuctionTransactionDto {
	private int bidId;
	private int productId;
	private int bidderCustomerId;
	private AuctionMaster auctionMaster;
	private double bidAmount;
	private Date dateTime;

	public AuctionTransactionDto() {
	}

	public AuctionTransactionDto(int productId, int bidderCustomerId, AuctionMaster auctionMaster, double bidAmount,
			Date dateTime) {
		this.bidderCustomerId = bidderCustomerId;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getbidderCustomerId() {
		return bidderCustomerId;
	}

	public void setbidderCustomerId(int bidderCustomerId) {
		this.bidderCustomerId = bidderCustomerId;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

=======
package com.widebidders.dto;

import java.util.Date;

import com.widebidders.models.entities.AuctionMaster;

public class AuctionTransactionDto {
	private int bidId;
	private int productId;
	private int bidderCustomerId;
	private AuctionMaster auctionMaster;
	private double bidAmount;
	private Date dateTime;

	public AuctionTransactionDto() {
	}

	public AuctionTransactionDto(int productId, int bidderCustomerId, AuctionMaster auctionMaster, double bidAmount,
			Date dateTime) {
		this.bidderCustomerId = bidderCustomerId;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getbidderCustomerId() {
		return bidderCustomerId;
	}

	public void setbidderCustomerId(int bidderCustomerId) {
		this.bidderCustomerId = bidderCustomerId;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
}