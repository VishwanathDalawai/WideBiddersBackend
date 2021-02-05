package com.widebidders.models.db;

import java.util.List;
import java.util.Map;

import java.util.Set;

import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;


public interface ProductDao {
	public int addProduct(Product product, Customer customer);	
    public void deleteProduct(int productId);
    public void updateProduct(Product Product);
    public List getProducts();
    public Product getProductById(int id);
    public List getProductProductName(String productName);
    public void addImage(ProductImage productImage);
    public Set getImages();
    public List getProductByCategory(String category);
	List getProductByCustomerId(int customerId);
	
}