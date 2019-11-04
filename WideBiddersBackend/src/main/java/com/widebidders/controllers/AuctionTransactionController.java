package com.widebidders.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.widebidders.dto.AuctionTransactionDto;
import com.widebidders.models.entities.AuctionTransaction;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.service.AuctionTransactionServiceImpl;

@RestController
public class AuctionTransactionController {
		private static final Logger logger = LoggerFactory.getLogger(AuctionTransactionController.class);
		
		@Autowired
		public AuctionTransactionServiceImpl auctionTransactionService;
		
		@RequestMapping(value = "/bid")
		public List getAllBids() {
			return auctionTransactionService.getAllBids();
		}

		@RequestMapping(value = "/bidId/{id}")
		public List getBidById(@PathVariable int id) {
			return auctionTransactionService.getBidById(id); 
		} 

		@RequestMapping(value = "/placeBid", method = RequestMethod.POST)
		public void addBid(@RequestBody AuctionTransactionDto auctionTransactionDto) {
			logger.error("Inside add Bid");
			int productId = auctionTransactionDto.getProductId();
			int customerId = auctionTransactionDto.getbidderCustomerId();
			AuctionTransaction auctionTransaction = new AuctionTransaction(auctionTransactionDto);
			auctionTransactionService.addBid(auctionTransaction, productId, customerId);			
		}

		@RequestMapping(value = "/deleteAuction/{id}", method = RequestMethod.DELETE)
		public void deleteBid(@PathVariable("id") int id) {
			auctionTransactionService.deleteAuction(id);
		}
		
		@RequestMapping(value = "/getBidAmount/{id}")
		public double getBidAmount(@PathVariable("id") int id) {
			return auctionTransactionService.getBidAmount(id);
		}
		
		@RequestMapping(value = "/getBidDetailsByProductId/{productId}")
		public List<AuctionTransaction> getBidDeatailsbyProductId(@PathVariable("productId") int productId) {
			 return auctionTransactionService.getBidDeatailsbyProductId(productId);
		}
}