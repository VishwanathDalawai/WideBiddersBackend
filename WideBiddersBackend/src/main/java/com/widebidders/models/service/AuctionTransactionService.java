package com.widebidders.models.service;

import java.util.List;

import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.AuctionTransaction;

public interface AuctionTransactionService {
	public List getAllBids();
	public List getBidById(int id);
	public void addBid(AuctionTransaction auction);
	public void deleteAuction(int id);
}
