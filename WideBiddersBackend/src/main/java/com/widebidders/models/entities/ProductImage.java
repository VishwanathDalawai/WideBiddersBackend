package com.widebidders.models.entities;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

public class ProductImage {
	private String productImage;
	private int productId;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductImage.class);
	
	public ProductImage() {
		
	}

	public ProductImage(String productImage, int productId) {
		this.productImage = productImage;
		this.productId = productId;	
	}
	
	public String getProductImage() {
		logger.info("Inside Product Image ");
		return productImage;
	}

	public void setProductImage(String productImage) {
		logger.info("Inside Product Image ");
			this.productImage = productImage;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;

		ProductImage obj2 = (ProductImage) obj;
		if ((this.productImage.equals(obj2.getProductImage()))
				&& (this.productId==obj2.getProductId())) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int tmp = 0;
		tmp = (productImage+productId).hashCode();
		return tmp;
	}

}
