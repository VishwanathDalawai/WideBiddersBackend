package com.widebidders.models.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;

@Service
public class ProductService {
 private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
 
 Map<Integer,Product> ProductMap = new HashMap<Integer, Product>();
 static int productId = 10;
 Set<ProductImage> productImages = new HashSet<ProductImage>();
 
 public ProductService() {
  ProductMap.put(1, new Product(1,"electronics", "tv", "battery performance", 20000, "yes", "no",2000,"2000","A8", productImages));
 }

 public Map<Integer, Product> getProducts() {
  return ProductMap;
 }

 public void addProduct(int id, Product product) {
  ProductMap.put(id, product); 
 }

 public Product getProductById(int id)
 {
  for (Integer key : ProductMap.keySet()) {
   if (key == id) {
    return ProductMap.get(key);
   }
  }
  logger.info("invalid key");
  return null;
 }

 public void delete(int id) {
  for (Integer key : ProductMap.keySet()) {
   if (key == id) {
    ProductMap.remove(key);
   }
  }
  logger.info("invalid key");
 }

 public void updateProduct(int id, Product product) {
  ProductMap.replace(id, product);
 }

 public void addImage(ProductImage productImage) {
  productImages.add(productImage);
 }

 public Set<ProductImage> getImages() {
      return productImages;
 }
}
