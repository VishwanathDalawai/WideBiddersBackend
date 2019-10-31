package com.widebidders.controllers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.widebidders.dto.ProductDto;
import com.widebidders.models.db.CustomerDao;
import com.widebidders.models.db.CustomerDaoImpl;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	public ProductServiceImpl ProductService;
	
	@Autowired
	public CustomerDaoImpl customerDaoImpl;
	
	@RequestMapping(value = "/products")
	public List getProducts() {
		return ProductService.getProducts();
	}

	@RequestMapping(value = "/productId/{id}")
	public List getProductById(@PathVariable int id) {
		return ProductService.getProductById(id); 
	} 

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public int addProduct(@RequestBody Product product, @RequestHeader int customerId) {
		logger.error("Inside add product"+product);
	/*	int customerId = productDto.getCustomerId();
		if(customerId==0){
			logger.info("User not logged in");
			return -1;
		}
		logger.info("Inside addProduct and customerId"+ customerId);
	
		Product product = new Product(productDto);
		*/
		logger.info("Inside addProduct Hello1");
		
		Customer customer = (Customer) customerDaoImpl.getCustomerById(customerId);
		
		logger.info("Inside addProduct Hello2");
		
		logger.info("Inside addProduct and Customer Name is"+customer.getCustomerName());
		
		ProductService.addProduct(product, customer);		
		return 0;
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
