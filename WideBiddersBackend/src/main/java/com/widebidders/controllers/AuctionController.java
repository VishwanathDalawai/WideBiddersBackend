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

import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.service.AuctionMasterServiceImpl;

@RestController
public class AuctionController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	public AuctionMasterServiceImpl auctionService;
	
	
	@RequestMapping(value = "/auction")
	public List getAllAuction() {
		return auctionService.getAuction();
	}

	@RequestMapping(value = "/auctionId/{id}")
	public List getAuctionById(@PathVariable int id) {
		return auctionService.getAuctionById(id); 
	} 

	@RequestMapping(value = "/addAuction", method = RequestMethod.POST)
	public void addAuction(@RequestBody AuctionMaster auction) {
		auctionService.addAuction(auction);			
	}

	@RequestMapping(value = "/deleteAuction/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		auctionService.deleteAuction(id);
	}

	@RequestMapping(value = "/updateAuction/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable("id") int id, @RequestBody AuctionMaster auctionrecord) {
		auctionService.updateAuction(id, auctionrecord);
	}
	


}
