package com.widebidders.models.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.widebidders.models.entities.Customer;
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
			logger.error("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public void addProduct(Product product, Customer customer) {
	    //logger.error("Inside add product DAO "+product.getProductImage());
		Session session = factory.openSession();
	    Transaction tx = null;
	    try {
	         tx = session.beginTransaction();
	         product.setCustomer(customer);
	         session.save(product);
	         /*
	         Set set = new HashSet<Customer>();
	         set.add(customer);
	 		 product.setCustomer(set);
	 		 */
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
			Product product = (Product) session.get(Product.class, productId);
			session.delete(product);
			tx.commit();
			logger.info("deleted successfully");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void updateProduct(int productId, Product Product) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Product> employee = (List) session.get(Product.class, productId);
			employee.set(productId, Product);
			session.update(employee);
			System.out.println(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List getProducts() {
		Session session = factory.openSession();
		Transaction tx = null;
		List products = null;
		try {
			
			tx = session.beginTransaction();
			products = session.createQuery("FROM Product ").list();
		
			/*
			tx = session.beginTransaction();
	         String sql = "SELECT * FROM PRODUCT";
	         SQLQuery query = session.createSQLQuery(sql);
	         query.addEntity(Product.class);
	         data = query.list();
	         */
	         tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return products;
	}

	@Override
	public List<Product> getProductById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Product> results = new ArrayList<Product>();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Product WHERE productId = :id";
			System.out.println("ID is " + id);
			Query query = session.createQuery(hql);
			query.setParameter("id", id);

			List<Product> list = query.list();
			results.addAll(list);

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	@Override
	public void addImage(ProductImage productImage) {
		logger.error("Inside add Image DAO " + productImage);
		Session session = factory.openSession();
		Transaction tx = null;
		Integer productId = null;

		try {
			tx = session.beginTransaction();
			// productId = (Integer) session.save(product);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
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

	@Override
	public List getProductByCategory(String category) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		List<Product> results = new ArrayList<Product>();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Product WHERE productCategoryName = :category";
			System.out.println("category is " + category);
			Query query = session.createQuery(hql);
			query.setParameter("category", category);

			List<Product> list = query.list();
			results.addAll(list);

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}


	@Override
	public List getProductProductName(String productName) {
	
		Session session = factory.openSession();
		Transaction tx = null;
		List<Product> results = new ArrayList<Product>();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Product WHERE productName = :productName";
			System.out.println("productName is " + productName);
			Query query = session.createQuery(hql);
			query.setParameter("productName", productName);

			List<Product> list = query.list();
			results.addAll(list);

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	@Override
	public List getProductByCustomerId(int customerId) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		List<Product> results = new ArrayList<Product>();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Product WHERE customerId = :customerId";
			System.out.println("customerId is " + customerId);
			Query query = session.createQuery(hql);
			query.setParameter("customerId", customerId);

			List<Product> list = query.list();
			results.addAll(list);

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

}
