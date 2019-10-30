package com.widebidders.models.service;

<<<<<<< HEAD
import java.util.HashMap;

import java.util.HashSet;
=======
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
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
public class ProductServiceImpl implements ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
<<<<<<< HEAD

=======
	
	
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
	@Autowired
<<<<<<< HEAD
	private ProductDaoImpl productDboImpl;
=======
    private ProductDaoImpl productDboImpl;
	
	public ProductServiceImpl() {
		
	}
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git

	@Override
	public List getProducts() {
		return productDboImpl.getProducts();
		// return ProductMap;
	}

<<<<<<< HEAD
	public void addProduct(Product product) {
		logger.error("Inside add product Service class" + product);
		productDboImpl.addProduct(product);
		// ProductMap.put(id, product);
=======
	@Override
	public void addProduct(Product product, Customer customer) {
		logger.error("Inside add product Service class"+product);
		productDboImpl.addProduct(product, customer);
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
	}

<<<<<<< HEAD
	public List getProductById(int id) {
=======
	@Override
	public List getProductById(int id){
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
		return productDboImpl.getProductById(id);
	}

	@Override
	public void deleteProduct(int id) {
		productDboImpl.deleteProduct(id);
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
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
<<<<<<< HEAD
	}

	public boolean loginAuthentication(LoginEntity login) {
		return false;

=======
>>>>>>> branch 'master' of https://github.com/Vishwanathpd/WideBiddersBackend.git
	}

}
