package com.widebidders.models.db;

import java.util.List;

import com.widebidders.models.entities.AuctionTransaction;

public interface AuctionTransactionDao {
	public List getAllBids();
	public List getBidById(int id);
	public int addBid(AuctionTransaction auction, int productId, int customerId);
	public void deleteAuction(int id);
	public List<AuctionTransaction> getBidDeatailsbyProductId(int productId);
	public double getBidAmount(int productId);
}
