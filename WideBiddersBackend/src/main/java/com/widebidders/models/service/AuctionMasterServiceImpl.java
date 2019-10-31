package com.widebidders.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.AuctionMasterDaoImpl;
import com.widebidders.models.entities.AuctionMaster;

@Service
public class AuctionMasterServiceImpl implements AuctionMasterService {

	@Autowired(required = true)
	private AuctionMasterDaoImpl auctionMasterDaoImpl;

	@Override
	public void addAuction(AuctionMaster auctionRecord) {
		auctionMasterDaoImpl.addAuction(auctionRecord);
	}

	@Override
	public void deleteAuction(int auctionId) {
		auctionMasterDaoImpl.deleteAuction(auctionId);
	}

	@Override
	public void updateAuction(int auctionId, AuctionMaster auctionRecord) {
		auctionMasterDaoImpl.updateAuction(auctionId, auctionRecord);
	}

	@Override
	public List getAuction() {
		return auctionMasterDaoImpl.getAuction();
	}

	@Override
	public List<AuctionMaster> getAuctionById(int id) {
		return auctionMasterDaoImpl.getAuctionById(id);
	}

}
