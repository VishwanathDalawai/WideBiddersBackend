package com.widebidders.models.db;

import java.util.List;

import com.widebidders.models.entities.AuctionTransaction;

public interface AuctionTransactionDao {
	public List getAllBids();
	public List getBidById(int id);
	public void addBid(AuctionTransaction auction);
	public void deleteAuction(int id);
}
