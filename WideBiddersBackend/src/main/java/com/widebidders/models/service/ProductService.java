package com.widebidders.models.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;

public interface ProductService {
	public int addProduct(Product product, Customer customer);
    public void deleteProduct(int productId);
    public void updateProduct(Product Product);
    public List getProducts();
    public Product getProductById(int id);
    public List<Product> getProductByCategory(String category);
    public List<Product> getProductByProductName(String productName);
    public List getProductByCustomerId(int customerId);
    public void addImage(ProductImage productImage);
    public Set getImages();
}
