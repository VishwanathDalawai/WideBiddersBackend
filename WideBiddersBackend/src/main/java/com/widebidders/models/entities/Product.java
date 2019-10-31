package com.widebidders.models.entities;

import java.util.Set;

import com.widebidders.dto.ProductDto;

public class Product {
	
	private int productId;
	private String productCategoryName;
	private String productName;
	private String productDescription;
	private double startingBidPrice;
	private String approvalStatus;
	private String reportFlag;
	private double incrementPrice;
	private String productBoughtYear;
	private String productModel;
	private Set<ProductImage> productImage;
	private Set<Customer> customer;
	
	public Product() {
	}
	
	public Product(String productCategoryName, String productName, String productDescription,
			double startingBidPrice, String approvalStatus, String reportFlag, double incrementPrice, String productBoughtYear,String productModel) {
		this.productCategoryName = productCategoryName;
		this.productName = productName;
		this.productDescription = productDescription;
		this.startingBidPrice = startingBidPrice;
		this.approvalStatus = approvalStatus;
		this.reportFlag = reportFlag;
		this.incrementPrice = incrementPrice;
		this.productModel = productModel;
		this.productBoughtYear = productBoughtYear;
	}
	public Product(ProductDto product) {
		this.productCategoryName = product.getProductCategoryName();
		this.productName = product.getProductName();
		this.productDescription = product.getProductDescription();
		this.startingBidPrice = product.getStartingBidPrice();
		this.approvalStatus = product.getApprovalStatus();
		this.reportFlag = product.getReportFlag();
		this.incrementPrice = product.getIncrementPrice();
		this.productModel = product.getProductModel();
		this.productBoughtYear = product.getProductBougthYear();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductBoughtYear() {
		return productBoughtYear;
	}

	public void setProductBoughtYear(String productBoughtYear) {
		this.productBoughtYear = productBoughtYear;
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getStartingBidPrice() {
		return startingBidPrice;
	}

	public void setStartingBidPrice(double startingBidPrice) {
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

	public double getIncrementPrice() {
		return incrementPrice;
	}

	public void setIncrementPrice(double incrementPrice) {
		this.incrementPrice = incrementPrice;
	}


	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public Set<ProductImage> getProductImage() {
		return productImage;
	}

	public void setProductImage(Set<ProductImage> productImage) {
		this.productImage = productImage;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}
}
