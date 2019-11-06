package com.widebidders.models.entities;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductImage {

	private String productImage;
	private int productImageId;

	private static final Logger logger = LoggerFactory.getLogger(ProductImage.class);

	public ProductImage() {

	}

	public ProductImage(String productImage, int productImageId) throws IOException {
		this.productImage = productImage;
		this.productImageId = productImageId;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		// System.out.println("Product Image"+productImage);
		this.productImage = productImage;
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}
}
