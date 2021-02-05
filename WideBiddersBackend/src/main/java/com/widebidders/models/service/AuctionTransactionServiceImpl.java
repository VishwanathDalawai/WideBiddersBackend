<<<<<<< HEAD
package com.widebidders.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.AuctionTransactionDaoImpl;
import com.widebidders.models.entities.AuctionTransaction;

@Service
public class AuctionTransactionServiceImpl implements AuctionTransactionService{

	@Autowired
	private AuctionTransactionDaoImpl auctionTransactionDaoImpl;

	@Override
	public List getAllBids() {
		return auctionTransactionDaoImpl.getAllBids();
	}

	@Override
	public List getBidById(int id) {
		return auctionTransactionDaoImpl.getBidById(id);
	}

	@Override
	public int addBid(AuctionTransaction auction,int productId, int customerId) {
		return auctionTransactionDaoImpl.addBid(auction, productId, customerId);
	}

	@Override
	public void deleteAuction(int id) {
		auctionTransactionDaoImpl.deleteAuction(id);		
	}

	public double getBidAmount(int productId) {
		return auctionTransactionDaoImpl.getBidAmount(productId);		
	}

	@Override
	public List<AuctionTransaction> getBidDeatailsbyProductId(int productId) {
		return auctionTransactionDaoImpl.getBidDeatailsbyProductId(productId);
	}
=======
package com.widebidders.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.AuctionTransactionDaoImpl;
import com.widebidders.models.entities.AuctionTransaction;

@Service
public class AuctionTransactionServiceImpl implements AuctionTransactionService{

	@Autowired
	private AuctionTransactionDaoImpl auctionTransactionDaoImpl;

	@Override
	public List getAllBids() {
		return auctionTransactionDaoImpl.getAllBids();
	}

	@Override
	public List getBidById(int id) {
		return auctionTransactionDaoImpl.getBidById(id);
	}

	@Override
	public int addBid(AuctionTransaction auction,int productId, int customerId) {
		return auctionTransactionDaoImpl.addBid(auction, productId, customerId);
	}

	@Override
	public void deleteAuction(int id) {
		auctionTransactionDaoImpl.deleteAuction(id);		
	}

	public double getBidAmount(int productId) {
		return auctionTransactionDaoImpl.getBidAmount(productId);		
	}

	@Override
	public List<AuctionTransaction> getBidDeatailsbyProductId(int productId) {
		return auctionTransactionDaoImpl.getBidDeatailsbyProductId(productId);
	}
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
}