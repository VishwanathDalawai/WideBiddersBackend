package com.widebidders.models.db;

import java.util.List;

import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;

public interface AuctionMasterDao {
	public void addAuction(AuctionMaster auctionRecord, Product product, Customer customer);
    public void deleteAuction(int auctionId);
    public void updateAuction(int auctionId, AuctionMaster auctionRecord);
    public List getAuction();
}
