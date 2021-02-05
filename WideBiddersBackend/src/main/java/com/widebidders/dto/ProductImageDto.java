<<<<<<< HEAD
package com.widebidders.dto;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.widebidders.models.entities.ProductImage;

public class ProductImageDto {

	private String productImage;
	private String productImage2;
	private String productImage3;
	private String productImage4;
	private String productImage5;
	private int productImageId;

	private static final Logger logger = LoggerFactory.getLogger(ProductImage.class);

	public ProductImageDto() {
	}

	public ProductImageDto(String productImage,String productImage2,String productImage3,String productImage4,String productImage5, int productImageId) throws IOException {
		this.productImage = productImage;
		this.productImage2 = productImage2;
		this.productImage3 = productImage3;
		this.productImage2 = productImage4;
		this.productImage3 = productImage5;
		this.productImageId = productImageId;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public String getProductImage2() {
		return productImage2;
	}

	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}

	public String getProductImage3() {
		return productImage3;
	}

	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}

	public String getProductImage4() {
		return productImage4;
	}

	public void setProductImage4(String productImage4) {
		this.productImage4 = productImage4;
	}

	public String getProductImage5() {
		return productImage5;
	}

	public void setProductImage5(String productImage5) {
		this.productImage5 = productImage5;
	}	
	
}
=======
package com.widebidders.dto;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.widebidders.models.entities.ProductImage;

public class ProductImageDto {

	private String productImage;
	private String productImage2;
	private String productImage3;
	private String productImage4;
	private String productImage5;
	private int productImageId;

	private static final Logger logger = LoggerFactory.getLogger(ProductImage.class);

	public ProductImageDto() {
	}

	public ProductImageDto(String productImage,String productImage2,String productImage3,String productImage4,String productImage5, int productImageId) throws IOException {
		this.productImage = productImage;
		this.productImage2 = productImage2;
		this.productImage3 = productImage3;
		this.productImage2 = productImage4;
		this.productImage3 = productImage5;
		this.productImageId = productImageId;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public String getProductImage2() {
		return productImage2;
	}

	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}

	public String getProductImage3() {
		return productImage3;
	}

	public void setProductImage3(String productImage3) {
		this.productImage3 = productImage3;
	}

	public String getProductImage4() {
		return productImage4;
	}

	public void setProductImage4(String productImage4) {
		this.productImage4 = productImage4;
	}

	public String getProductImage5() {
		return productImage5;
	}

	public void setProductImage5(String productImage5) {
		this.productImage5 = productImage5;
	}	
	
}
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
