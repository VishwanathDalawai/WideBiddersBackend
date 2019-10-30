package com.widebidders.models.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.ProductDaoImpl;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	
	@Autowired
    private ProductDaoImpl productDboImpl;
	
	public ProductServiceImpl() {
		
	}

	@Override
	public List getProducts() {
		return productDboImpl.getProducts();
		//return ProductMap;
	}

	@Override
	public void addProduct(Product product, Customer customer) {
		logger.error("Inside add product Service class"+product);
		productDboImpl.addProduct(product, customer);
	}

	@Override
	public List getProductById(int id){
		return productDboImpl.getProductById(id);
	}

	@Override
	public void deleteProduct(int id) {
		productDboImpl.deleteProduct(id);
	}

	@Override
	public void updateProduct(int id, Product product) {
		productDboImpl.updateProduct(id, product);
	}

	@Override
	public void addImage(ProductImage productImage) {
		logger.info("Inside Add Image of product service impl");
	}

	@Override
	public Set getImages() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
