package com.widebidders.models.entities;

import java.util.Set;

public class Product {
	
	private int productId;
	private String productCategoryName;
	private String productName;
	private String description;
	private int startingBidPrice;
	private String approvalStatus;
	private String reportFlag;
	private int incrementPrice;
	private String year;
	private String productModel;
	private Set<ProductImage> productImage;
	
	public Set<ProductImage> getProductImage() {
		return  productImage;
	}

	public void setProductImage(Set<ProductImage> productImage) {
		this.productImage = productImage;
	}

	public Product() {
	}
	
	public Product(int productId, String productCategoryName, String productName, String description,
			int startingBidPrice, String approvalStatus, String reportFlag, int incrementPrice, String year,String productModel,Set<ProductImage> ProductImage) {
		this.productId = productId;
		this.productCategoryName = productCategoryName;
		this.productName = productName;
		this.description = description;
		this.startingBidPrice = startingBidPrice;
		this.approvalStatus = approvalStatus;
		this.reportFlag = reportFlag;
		this.incrementPrice = incrementPrice;
		this.year = year;
		this.productModel = productModel;
		this.productImage=ProductImage;
	}

	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStartingBidPrice() {
		return startingBidPrice;
	}

	public void setStartingBidPrice(int startingBidPrice) {
		this.startingBidPrice = startingBidPrice;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getReportFlag() {
		return reportFlag;
	}

	public void setReportFlag(String reportFlag) {
		this.reportFlag = reportFlag;
	}

	public int getIncrementPrice() {
		return incrementPrice;
	}

	public void setIncrementPrice(int incrementPrice) {
		this.incrementPrice = incrementPrice;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	
}
