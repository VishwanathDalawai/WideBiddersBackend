package com.widebidders.dto;

import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.Customer;

public class AuctionTransactionDto {
		private int bidId; 
		private int productId;
		private Customer bidderCustomer;
		private AuctionMaster auctionMaster;
		private double bidAmount;
		private String dateTime;
		
		public AuctionTransactionDto() {
		}
		
		public AuctionTransactionDto(int productId, Customer bidderCustomer, AuctionMaster auctionMaster, double bidAmount, String dateTime){
			this.bidderCustomer = bidderCustomer;
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