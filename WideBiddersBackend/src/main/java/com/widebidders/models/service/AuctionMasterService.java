package com.widebidders.models.service;

import java.util.List;
import java.util.Set;

import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.CustomerAddress;

public interface AuctionMasterService {
	public void addAuction(AuctionMaster auctionRecord);
    public void deleteAuction(int auctionId);
    public void updateAuction(int auctionId, AuctionMaster auctionRecord);
    public List<AuctionMaster> getAuction();
    public List<AuctionMaster> getAuctionById(int id);
}
