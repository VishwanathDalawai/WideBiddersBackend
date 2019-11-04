package com.widebidders.models.db;

import java.util.List;

import com.widebidders.models.entities.AuctionTransaction;

public interface AuctionTransactionDao {
	public List getAllBids();
	public List getBidById(int id);
	public void addBid(AuctionTransaction auction, int productId, int customerId);
	public void deleteAuction(int id);
<<<<<<< HEAD
	public AuctionTransaction getBidDeatailsbyProductId(int productId);
=======
	public List<AuctionTransaction> getBidDeatailsbyProductId(int productId);
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
}
