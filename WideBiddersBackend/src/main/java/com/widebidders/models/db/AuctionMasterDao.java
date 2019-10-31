package com.widebidders.models.db;

import java.util.List;

import com.widebidders.models.entities.AuctionMaster;

public interface AuctionMasterDao {
	public void addAuction(AuctionMaster auctionRecord);
    public void deleteAuction(int auctionId);
    public void updateAuction(int auctionId, AuctionMaster auctionRecord);
    public List getAuction();
    public List<AuctionMaster> getAuctionById(int id);

}
