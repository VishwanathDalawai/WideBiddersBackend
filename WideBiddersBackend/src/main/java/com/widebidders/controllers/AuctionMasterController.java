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

import com.widebidders.dto.AuctionMasterDto;
import com.widebidders.models.db.CustomerDaoImpl;
import com.widebidders.models.db.ProductDaoImpl;
import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.service.AuctionMasterServiceImpl;

@RestController
public class AuctionMasterController {
	private static final Logger logger = LoggerFactory.getLogger(AuctionMasterController.class);
	
	@Autowired
	public AuctionMasterServiceImpl auctionService;
	
	@Autowired
	public ProductDaoImpl productDaoImpl;
	
	@Autowired
	public CustomerDaoImpl customerDaoImpl;
	
	@RequestMapping(value = "/auctionMaster")
	public List getAllAuctions() {
		return auctionService.getAuction();
	}

	@RequestMapping(value = "/auctionMasterId/{id}")
	public List getAuctionById(@PathVariable int id) {
		return auctionService.getAuctionById(id); 
	} 

	@RequestMapping(value = "/addAuctionMaster", method = RequestMethod.POST)
	public void addAuction(@RequestBody AuctionMasterDto auctionMasterDto) {
		logger.info("Inside Add Auction Master Controller");
		int customerId = auctionMasterDto.getCustomerId();
		int productId = auctionMasterDto.getProductId();
		AuctionMaster auctionMaster = new AuctionMaster(auctionMasterDto);
		
		Product product = productDaoImpl.getProductById(productId);	
		Customer customer = customerDaoImpl.getCustomerById(customerId);
		auctionService.addAuction(auctionMaster, product, customer);			
	}

	@RequestMapping(value = "/deleteAuctionMaster/{id}", method = RequestMethod.DELETE)
	public void deleteAuction(@PathVariable("id") int id) {
		auctionService.deleteAuction(id);
	}

	@RequestMapping(value = "/updateAuctionMaster/{id}", method = RequestMethod.PUT)
	public void updateAuction(@PathVariable("id") int id, @RequestBody AuctionMaster auctionrecord) {
		auctionService.updateAuction(id, auctionrecord);
	}
}
