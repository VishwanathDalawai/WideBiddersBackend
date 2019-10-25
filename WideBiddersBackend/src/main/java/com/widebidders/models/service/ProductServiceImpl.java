package com.widebidders.models.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.ProductDaoImpl;
import com.widebidders.models.entities.LoginEntity;
import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	HttpSession httpSession;
	
	Map<Integer,Product> ProductMap = new HashMap<Integer, Product>();
	static int productId = 10;
	Set productImages = new HashSet();
	
	@Autowired
    private ProductDaoImpl productDboImpl;
	
	public ProductServiceImpl() {
		ProductMap.put(1, new Product(1,"electronics", "tv", "battery performance", 20000, "yes", "no",2000,"2000","A8 Model"));
	}

	public List getProducts() {
		return productDboImpl.getProducts();
		//return ProductMap;
	}

	public void addProduct(Product product) {
		logger.error("Inside add product Service class"+product);
		productDboImpl.addProduct(product); 
		//ProductMap.put(id, product);	
	}

	public List getProductById(int id){
		return productDboImpl.getProductById(id);
	}

	public void deleteProduct(int id) {
		productDboImpl.deleteProduct(id);
	}
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
	public boolean loginAuthentication(LoginEntity login)
	{
		return false;
		
	}
	
}
