package com.widebidders.controllers;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.widebidders.models.entities.ProductImage;
import com.widebidders.models.service.ProductService;

@RestController
public class ProductImageController {


	static int idIncreamentForProduct = 10;
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	public ProductService ProductService;
	
	@RequestMapping(value = "/addImage", method = RequestMethod.POST)
	public void addImage(@RequestBody ProductImage productImage) {
		ProductService.addImage(productImage);
	}
	
	@RequestMapping(value = "/images")
	public Set<ProductImage> getImages() {
		return ProductService.getImages();
	}
}
