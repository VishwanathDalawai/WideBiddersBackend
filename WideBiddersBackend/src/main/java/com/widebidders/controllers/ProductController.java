package com.widebidders.controllers;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.widebidders.models.entities.Product;
import com.widebidders.models.service.ProductServiceImpl;

@RestController
public class ProductController {

	static int idIncreamentForProduct = 10;
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	public ProductServiceImpl ProductService;
	
	@RequestMapping(value = "/products")
	public List getProducts() {
		return ProductService.getProducts();
	}

	@RequestMapping(value = "/productId/{id}")
	public Product getProductById(@PathVariable int id) {
		return ProductService.getProductById(id);
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public void addProduct(@RequestBody Product product) {
		idIncreamentForProduct++;
		logger.error("Inside add product"+product);
		ProductService.addProduct(idIncreamentForProduct, product);
		product.setProductId(idIncreamentForProduct); 
	}

	@RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		ProductService.deleteProduct(id);
	}

	@RequestMapping(value = "/productUpdate/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable("id") int id, @RequestBody Product Product) {
		ProductService.updateProduct(id, Product);
	}
}
