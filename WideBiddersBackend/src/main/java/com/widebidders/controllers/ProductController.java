package com.widebidders.controllers;

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
	
	@RequestMapping(value = "/products")
	public List getProducts() {
		return ProductService.getProducts();
	}

	@RequestMapping(value = "/productId/{id}")
	public List getProductById(@PathVariable int id) {
		return ProductService.getProductById(id); 
	} 

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public void addProduct(@RequestBody ProductDto productDto) {
		logger.error("Inside add product"+productDto);
		//Customer customer = (Customer)request.getAttribute("customer");
		//logger.info("Inside product Controller"+customer.getCustomerName());=
		Product product = new Product(productDto);
		CustomerDaoImpl customerDaoImpl =new CustomerDaoImpl();
		int customerId = productDto.getCustomerId();
		logger.info("Inside add product and customerId"+ customerId);
		List customer = customerDaoImpl.getCustomerById(customerId);
		product.setCustomer((Set<Customer>) customer);
		ProductService.addProduct(product);
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
