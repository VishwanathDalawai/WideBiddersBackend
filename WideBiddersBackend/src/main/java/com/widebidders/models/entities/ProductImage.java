<<<<<<< HEAD
package com.widebidders.models.entities;

import java.io.IOException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.widebidders.dto.ProductImageDto;

@Entity
@Table(name = "Product_Image")
public class ProductImage {

	@Lob
	@Column(name = "Product_Image", columnDefinition = "BLOB")
	private byte[] productImage;

	@Lob
	@Column(name = "Product_Image2", columnDefinition = "BLOB")
	private byte[] productImage2;

	@Lob
	@Column(name = "Product_Image3", columnDefinition = "BLOB")
	private byte[] productImage3;

	@Lob
	@Column(name = "Product_Image4", columnDefinition = "BLOB")
	private byte[] productImage4;

	@Lob
	@Column(name = "Product_Image5", columnDefinition = "BLOB")
	private byte[] productImage5;

	@Id
	@Column(name = "productImageId")
	@GeneratedValue
	private int productImageId;

	private static final Logger logger = LoggerFactory.getLogger(ProductImage.class);

	public ProductImage() {
	}

	public ProductImage(byte[] productImage, byte[] productImage2, byte[] productImage3, byte[] productImage4,
			byte[] productImage5, int productImageId) throws IOException {
		this.productImage = productImage;
		this.productImage2 = productImage2;
		this.productImage3 = productImage3;
		this.productImage4 = productImage4;
		this.productImage5 = productImage5;
		this.productImageId = productImageId;
	}

	public ProductImage(ProductImageDto productImageDto) {
		System.out.println("Image " + productImageDto.getProductImage());
		byte[] scanBytes = Base64.getDecoder().decode(productImageDto.getProductImage());
		this.productImage = scanBytes;
		if (productImageDto.getProductImage2() != null) {
			byte[] scanBytestwo = Base64.getDecoder().decode(productImageDto.getProductImage2());
			this.productImage2 = scanBytestwo;
		}
		if (productImageDto.getProductImage3() != null) {
			byte[] scanBytes3 = Base64.getDecoder().decode(productImageDto.getProductImage3());
			this.productImage3 = scanBytes3;
		}
		if (productImageDto.getProductImage4() != null) {
			byte[] scanBytes4 = Base64.getDecoder().decode(productImageDto.getProductImage4());
			this.productImage4 = scanBytes4;
		}
		if (productImageDto.getProductImage5() != null) {
			byte[] scanBytes5 = Base64.getDecoder().decode(productImageDto.getProductImage5());
			this.productImage5 = scanBytes5;
		}
		this.productImageId = productImageDto.getProductImageId();
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public byte[] getProductImage2() {
		return productImage2;
	}

	public void setProductImage2(byte[] productImage2) {
		this.productImage2 = productImage2;
	}

	public byte[] getProductImage3() {
		return productImage3;
	}

	public void setProductImage3(byte[] productImage3) {
		this.productImage3 = productImage3;
	}

	public byte[] getProductImage4() {
		return productImage4;
	}

	public void setProductImage4(byte[] productImage4) {
		this.productImage4 = productImage4;
	}

	public byte[] getProductImage5() {
		return productImage5;
	}

	public void setProductImage5(byte[] productImage5) {
		this.productImage5 = productImage5;
	}
=======
package com.widebidders.models.entities;

import java.io.IOException;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.widebidders.dto.ProductImageDto;

@Entity
@Table(name = "Product_Image")
public class ProductImage {

	@Lob
	@Column(name = "Product_Image", columnDefinition = "BLOB")
	private byte[] productImage;

	@Lob
	@Column(name = "Product_Image2", columnDefinition = "BLOB")
	private byte[] productImage2;

	@Lob
	@Column(name = "Product_Image3", columnDefinition = "BLOB")
	private byte[] productImage3;

	@Lob
	@Column(name = "Product_Image4", columnDefinition = "BLOB")
	private byte[] productImage4;

	@Lob
	@Column(name = "Product_Image5", columnDefinition = "BLOB")
	private byte[] productImage5;

	@Id
	@Column(name = "productImageId")
	@GeneratedValue
	private int productImageId;

	private static final Logger logger = LoggerFactory.getLogger(ProductImage.class);

	public ProductImage() {
	}

	public ProductImage(byte[] productImage, byte[] productImage2, byte[] productImage3, byte[] productImage4,
			byte[] productImage5, int productImageId) throws IOException {
		this.productImage = productImage;
		this.productImage2 = productImage2;
		this.productImage3 = productImage3;
		this.productImage4 = productImage4;
		this.productImage5 = productImage5;
		this.productImageId = productImageId;
	}

	public ProductImage(ProductImageDto productImageDto) {
		System.out.println("Image " + productImageDto.getProductImage());
		byte[] scanBytes = Base64.getDecoder().decode(productImageDto.getProductImage());
		this.productImage = scanBytes;
		if (productImageDto.getProductImage2() != null) {
			byte[] scanBytestwo = Base64.getDecoder().decode(productImageDto.getProductImage2());
			this.productImage2 = scanBytestwo;
		}
		if (productImageDto.getProductImage3() != null) {
			byte[] scanBytes3 = Base64.getDecoder().decode(productImageDto.getProductImage3());
			this.productImage3 = scanBytes3;
		}
		if (productImageDto.getProductImage4() != null) {
			byte[] scanBytes4 = Base64.getDecoder().decode(productImageDto.getProductImage4());
			this.productImage4 = scanBytes4;
		}
		if (productImageDto.getProductImage5() != null) {
			byte[] scanBytes5 = Base64.getDecoder().decode(productImageDto.getProductImage5());
			this.productImage5 = scanBytes5;
		}
		this.productImageId = productImageDto.getProductImageId();
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public byte[] getProductImage2() {
		return productImage2;
	}

	public void setProductImage2(byte[] productImage2) {
		this.productImage2 = productImage2;
	}

	public byte[] getProductImage3() {
		return productImage3;
	}

	public void setProductImage3(byte[] productImage3) {
		this.productImage3 = productImage3;
	}

	public byte[] getProductImage4() {
		return productImage4;
	}

	public void setProductImage4(byte[] productImage4) {
		this.productImage4 = productImage4;
	}

	public byte[] getProductImage5() {
		return productImage5;
	}

	public void setProductImage5(byte[] productImage5) {
		this.productImage5 = productImage5;
	}
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
}