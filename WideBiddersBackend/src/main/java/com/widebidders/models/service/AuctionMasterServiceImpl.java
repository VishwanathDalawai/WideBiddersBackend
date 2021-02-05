<<<<<<< HEAD
package com.widebidders.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.AuctionMasterDaoImpl;
import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.AuctionTransaction;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;

@Service
public class AuctionMasterServiceImpl implements AuctionMasterService {

	@Autowired(required = true)
	private AuctionMasterDaoImpl auctionMasterDaoImpl;

	@Override
	public void addAuction(AuctionMaster auctionRecord, Product product, Customer customer) {
		auctionMasterDaoImpl.addAuction(auctionRecord, product, customer);
	}

	@Override
	public void deleteAuction(int auctionId) {
		auctionMasterDaoImpl.deleteAuction(auctionId);
	}

	@Override
	public void updateAuction(int auctionId, AuctionMaster auctionRecord) {
		auctionMasterDaoImpl.updateAuction(auctionId, auctionRecord);
	}

	@Override
	public List getAuction() {
		return auctionMasterDaoImpl.getAuction();
	}

	@Override
	public List<AuctionMaster> getAuctionById(int id) {
		return auctionMasterDaoImpl.getAuctionById(id);
	}

	public AuctionMaster getBidDates(int productId) {
		return auctionMasterDaoImpl.getBidDates(productId);		
	}
	@Override
	public void getBidDetailsById(int productId) {
		auctionMasterDaoImpl.getBidDetailsById(productId);	
	}
}
=======
package com.widebidders.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.AuctionMasterDaoImpl;
import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.AuctionTransaction;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;

@Service
public class AuctionMasterServiceImpl implements AuctionMasterService {

	@Autowired(required = true)
	private AuctionMasterDaoImpl auctionMasterDaoImpl;

	@Override
	public void addAuction(AuctionMaster auctionRecord, Product product, Customer customer) {
		auctionMasterDaoImpl.addAuction(auctionRecord, product, customer);
	}

	@Override
	public void deleteAuction(int auctionId) {
		auctionMasterDaoImpl.deleteAuction(auctionId);
	}

	@Override
	public void updateAuction(int auctionId, AuctionMaster auctionRecord) {
		auctionMasterDaoImpl.updateAuction(auctionId, auctionRecord);
	}

	@Override
	public List getAuction() {
		return auctionMasterDaoImpl.getAuction();
	}

	@Override
	public List<AuctionMaster> getAuctionById(int id) {
		return auctionMasterDaoImpl.getAuctionById(id);
	}

	public AuctionMaster getBidDates(int productId) {
		return auctionMasterDaoImpl.getBidDates(productId);		
	}
	@Override
	public void getBidDetailsById(int productId) {
		auctionMasterDaoImpl.getBidDetailsById(productId);	
	}
}
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
