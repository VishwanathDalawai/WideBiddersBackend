package com.widebidders.models.entities;

import java.io.IOException;
import java.sql.Blob;

import javax.persistence.Lob;

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
		System.out.println("Product Image"+productImage);
		this.productImage = productImage;
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	/*public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;

		ProductImage obj2 = (ProductImage) obj;
		if ((this.productImage.equals(obj2.getProductImage()))) {
			return true;
		}
		return false;
	}*/

	/*public int hashCode() {
		//int tmp = 0;
		//tmp = (productImage+productImageId).hashCode();
		return productImageId;
	}
*/
}
