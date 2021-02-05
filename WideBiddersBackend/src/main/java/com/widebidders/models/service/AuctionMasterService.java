<<<<<<< HEAD
package com.widebidders.models.service;

import java.util.List;

import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;

public interface AuctionMasterService {
	public void addAuction(AuctionMaster auctionRecord, Product product, Customer customer);
	    public void deleteAuction(int auctionId);
	    public void updateAuction(int auctionId, AuctionMaster auctionRecord);
	    public List getAuction();
	    public List<AuctionMaster> getAuctionById(int id);
	    public void getBidDetailsById(int productId);
	    public AuctionMaster getBidDates(int productId);
}
=======
package com.widebidders.models.service;

import java.util.List;

import com.widebidders.models.entities.AuctionMaster;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;

public interface AuctionMasterService {
	public void addAuction(AuctionMaster auctionRecord, Product product, Customer customer);
	    public void deleteAuction(int auctionId);
	    public void updateAuction(int auctionId, AuctionMaster auctionRecord);
	    public List getAuction();
	    public List<AuctionMaster> getAuctionById(int id);
	    public void getBidDetailsById(int productId);
	    public AuctionMaster getBidDates(int productId);
}
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
