package com.widebidders.models.db;

import java.util.Iterator;
import java.util.List;

import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.widebidders.models.entities.Product;
import com.widebidders.models.entities.ProductImage;

@Repository
public class ProductDaoImpl implements ProductDao {
	
    private SessionFactory factory;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	public ProductDaoImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
	     } catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	     }
	}
	
	@Override
	public void addProduct(int id, Product product) {
	    logger.error("Inside add product DAO "+product.getProductImage());
		Session session = factory.openSession();
	    Transaction tx = null;
	    Integer productId = null;
	    try {
	         tx = session.beginTransaction();
	         session.save(product);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}

	@Override
	public void deleteProduct(int productId) {
		
		   Session session = factory.openSession();
		      Transaction tx = null;
		      
		      try {
		         tx = session.beginTransaction();
		         Product employee = (Product)session.get(Product.class, productId); 
		         session.delete(employee); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		
	}

	@Override
	public void updateProduct(int productId, Product Product) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getProducts() {
		Session session = factory.openSession();
	      Transaction tx = null;
	      List products = null;
	      try {
	         tx = session.beginTransaction();
	 		 products = session.createQuery("FROM Product").list();
	         for (Iterator iterator1 = products.iterator(); iterator1.hasNext();){
	            Product product = (Product) iterator1.next(); 
	            System.out.print("First Name: " + product.getProductId()); 
	            System.out.print("  Last Name: " + product.getProductName()); 
	            System.out.println("  Salary: " + product.getProductDescription());
	            System.out.println("  Salary: " + product.getProductBougthYear());
	            System.out.println("  Salary: " + product.getProductCategoryName());
	            System.out.println("  Salary: " + product.getProductModel());
	            System.out.println("  Salary: " + product.getProductDescription());
	            System.out.println("  Salary: " + product.getApprovalStatus());
	            System.out.println("  Salary: " + product.getStartingBidPrice());
	            System.out.println("  Salary: " + product.getIncrementPrice());
	            Set<ProductImage> images = product.getProductImage();
	            for (Iterator iterator2 = images.iterator(); iterator2.hasNext();){
	            	ProductImage certName = (ProductImage) iterator2.next(); 
	               System.out.println("images: " + certName.getProductImage());
	               System.out.println("images: " + certName.getProductImageId());
	            }
	         }	         
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return products;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addImage(ProductImage productImage) {
	    logger.error("Inside add Image DAO "+productImage);
		Session session = factory.openSession();
	    Transaction tx = null;
	    Integer productId = null;

	    try {
	         tx = session.beginTransaction();
	    //     productId = (Integer) session.save(product); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	}

	@Override
	public Set getImages() {
		// TODO Auto-generated method stub
		return null;
	}

}
