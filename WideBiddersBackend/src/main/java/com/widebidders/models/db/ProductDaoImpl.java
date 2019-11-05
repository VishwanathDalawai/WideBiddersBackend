package com.widebidders.models.db;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

@Repository("ProductDao")
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

	public int addProduct(Product product, Customer customer) {
		// logger.error("Inside add product DAO "+product.getProductImage());
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			product.setCustomer(customer);
			session.save(product);
			tx.commit();
			return product.getProductId();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return -1;
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
	public void updateProduct(Product product) {
		
		Session session = factory.openSession();
		Transaction tx = null;

		int productId = product.getProductId();
		System.out.println("Product id is "+productId);

		try {
			tx = session.beginTransaction();
			Product previousProduct = (Product) session.get(Product.class, productId);
			logger.info("productId");
			//previousProduct.setCustomer(product.getCustomer());
			previousProduct.setProductDescription(product.getProductDescription());
			session.evict(product);
			logger.info("inside update");
			session.update(previousProduct);
			logger.info("after everythning");
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
			products = session.createQuery("FROM Product").list();
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
	public Product getProductById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Product> products = new ArrayList<Product>();
		try {
			products = session.createQuery("FROM Product").list();
			for (Iterator iterator1 = products.iterator(); iterator1.hasNext();) {
				logger.info("Inside getProductByID ");
				Product product = (Product) iterator1.next();
				if (product.getProductId() == id) {
					return product;
				}
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
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
			String hql = "FROM Product WHERE lower(productName) like :productName";
			System.out.println("productName is " + productName);
			Query query = session.createQuery(hql);
			query.setParameter("productName" , "%"+productName.toLowerCase()+ "%");
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
		// Integer customerId=customer.getCustomerId();
		try {
			tx = session.beginTransaction();
			List products = session.createQuery("FROM Product").list();
			for (Iterator iterator = products.iterator(); iterator.hasNext();) {
				Product product = (Product) iterator.next();
				Customer customer = product.getCustomer();
				if (customer.getCustomerId() == customerId) {
					results.add(product);
				}
			}
			logger.info("list size is " + results.size());
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
