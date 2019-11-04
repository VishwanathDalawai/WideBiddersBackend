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
	public void addBid(AuctionTransaction auction,int productId, int customerId) {
		auctionTransactionDaoImpl.addBid(auction, productId, customerId);
	}

	@Override
	public void deleteAuction(int id) {
		auctionTransactionDaoImpl.deleteAuction(id);		
	}

<<<<<<< HEAD
	@Override
	public AuctionTransaction getBidDeatailsbyProductId(int productId) {
=======
	public double getBidAmount(int productId) {
		return auctionTransactionDaoImpl.getBidAmount(productId);		
	}

	@Override
	public List<AuctionTransaction> getBidDeatailsbyProductId(int productId) {
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
		return auctionTransactionDaoImpl.getBidDeatailsbyProductId(productId);
	}
}
