<<<<<<< HEAD
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
import com.widebidders.dto.ProductImageDto;
import com.widebidders.models.db.CustomerDao;
import com.widebidders.models.db.CustomerDaoImpl;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;
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
	public Product getProductById(@PathVariable int id) {
		return ProductService.getProductById(id);
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public int addProduct(@RequestBody ProductDto productDto) {
		int customerId = productDto.getCustomerId();
		if(customerId==0){
			logger.info("User not logged in");
			return -1;
		}
		
		Product product = new Product(productDto);
		ProductImage productimage = new ProductImage(productDto.getProductImage());
		product.setProductImage(productimage);
		Customer customer = (Customer) customerDaoImpl.getCustomerById(customerId);
		return ProductService.addProduct(product, customer);		
	}

	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		ProductService.deleteProduct(id);
	}

	@RequestMapping(value = "/productUpdate", method = RequestMethod.PUT)
	public void updateProduct(@RequestBody ProductDto productDto) {
		Product product = new Product(productDto);
		ProductService.updateProduct(product);
	}

	@RequestMapping(value = "/productByCategory/{category}")
	public List getProductByCategory(@PathVariable("category") String category) {
		return ProductService.getProductByCategory(category);
	}

	@RequestMapping(value = "/productByCustomerId/{id}")
	public List getProductByCustomerId(@PathVariable int id) {
		return ProductService.getProductByCustomerId(id);
	}

	@RequestMapping(value = "/productByProductName/{productName}")
	public List getProductByProductName(@PathVariable("productName") String productName) {
		return ProductService.getProductByProductName(productName);
	}
}
=======
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
import com.widebidders.dto.ProductImageDto;
import com.widebidders.models.db.CustomerDao;
import com.widebidders.models.db.CustomerDaoImpl;
import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;
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
	public Product getProductById(@PathVariable int id) {
		return ProductService.getProductById(id);
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public int addProduct(@RequestBody ProductDto productDto) {
		int customerId = productDto.getCustomerId();
		if(customerId==0){
			logger.info("User not logged in");
			return -1;
		}
		
		Product product = new Product(productDto);
		ProductImage productimage = new ProductImage(productDto.getProductImage());
		product.setProductImage(productimage);
		Customer customer = (Customer) customerDaoImpl.getCustomerById(customerId);
		return ProductService.addProduct(product, customer);		
	}

	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		ProductService.deleteProduct(id);
	}

	@RequestMapping(value = "/productUpdate", method = RequestMethod.PUT)
	public void updateProduct(@RequestBody ProductDto productDto) {
		Product product = new Product(productDto);
		ProductService.updateProduct(product);
	}

	@RequestMapping(value = "/productByCategory/{category}")
	public List getProductByCategory(@PathVariable("category") String category) {
		return ProductService.getProductByCategory(category);
	}

	@RequestMapping(value = "/productByCustomerId/{id}")
	public List getProductByCustomerId(@PathVariable int id) {
		return ProductService.getProductByCustomerId(id);
	}

	@RequestMapping(value = "/productByProductName/{productName}")
	public List getProductByProductName(@PathVariable("productName") String productName) {
		return ProductService.getProductByProductName(productName);
	}
}
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
