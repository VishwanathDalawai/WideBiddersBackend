<<<<<<< HEAD
package com.widebidders.models.service;

import java.util.List;

import com.widebidders.models.entities.AuctionTransaction;

public interface AuctionTransactionService {
	public List getAllBids();
	public List getBidById(int id);
	public int addBid(AuctionTransaction auction,int productId, int customerId);
	public void deleteAuction(int id);
	public List<AuctionTransaction> getBidDeatailsbyProductId(int productId);
=======
package com.widebidders.models.service;

import java.util.List;

import com.widebidders.models.entities.AuctionTransaction;

public interface AuctionTransactionService {
	public List getAllBids();
	public List getBidById(int id);
	public int addBid(AuctionTransaction auction,int productId, int customerId);
	public void deleteAuction(int id);
	public List<AuctionTransaction> getBidDeatailsbyProductId(int productId);
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
}