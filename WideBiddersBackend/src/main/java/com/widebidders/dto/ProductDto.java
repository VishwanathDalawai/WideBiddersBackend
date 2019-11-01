package com.widebidders.dto;

import java.io.Serializable;
import java.util.Set;

import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;

public class ProductDto implements Serializable{

	private int productId;
	private String productCategoryName;
	private String productName;
	private String productDescription;
	private double startingBidPrice;
	private String approvalStatus;
	private String reportFlag;
	private double incrementPrice;
	private String productBougthYear;
	private String productModel;
	private Set<ProductImage> productImage;
	private int customerId;

	public ProductDto() {

	}

	public ProductDto(Product product) {

		this.productCategoryName = product.getProductCategoryName();
		this.productName = product.getProductName();
		this.productDescription = product.getProductDescription();
		this.startingBidPrice = product.getStartingBidPrice();
		this.approvalStatus = product.getApprovalStatus();
		this.reportFlag = product.getReportFlag();
		this.incrementPrice = product.getIncrementPrice();
		this.productModel = product.getProductModel();
		this.productBougthYear=product.getProductBoughtYear();

	}

	public ProductDto(int productId, String productCategoryName, String productName, String productDescription,
			double startingBidPrice, String approvalStatus, String reportFlag, double incrementPrice,
			String ProductBougthYear, String productModel, int customerId) {
		this.productId = productId;
		this.productCategoryName = productCategoryName;
		this.productName = productName;
		this.productDescription = productDescription;
		this.startingBidPrice = startingBidPrice;
		this.approvalStatus = approvalStatus;
		this.reportFlag = reportFlag;
		this.incrementPrice = incrementPrice;
		this.productModel = productModel;
		this.customerId = customerId;
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

	public String getProductBougthYear() {
		return productBougthYear;
	}

	public void setProductBougthYear(String productBougthYear) {
		this.productBougthYear = productBougthYear;
	}

	public String getProductModel() {
		return productModel;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

}
