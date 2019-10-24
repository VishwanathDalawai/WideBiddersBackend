package com.widebidders.models.service;

import java.util.Map;
import java.util.Set;

import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;

public interface ProductService {
	public void addProduct(int id, Product product);
    public void deleteProduct(int productId);
    public void updateProduct(int productId, Product Product);
    public Map<Integer, Product> getProducts();
    public Product getProductById(int id);
    public void addImage(ProductImage productImage);
    public Set getImages();
}
