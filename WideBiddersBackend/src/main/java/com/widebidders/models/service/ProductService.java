package com.widebidders.models.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.widebidders.models.entities.Customer;
import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;

public interface ProductService {
	public void addProduct(Product product, Customer customer);
    public void deleteProduct(int productId);
    public void updateProduct(int productId, Product Product);
    public List getProducts();
    public List<Product> getProductById(int id);
    public void addImage(ProductImage productImage);
    public Set getImages();
}
