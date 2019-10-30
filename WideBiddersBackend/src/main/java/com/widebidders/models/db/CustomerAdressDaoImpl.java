package com.widebidders.models.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.widebidders.models.entities.CustomerAddress;

@Repository
public class CustomerAdressDaoImpl implements CustomerAdressDao {
	private SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	public CustomerAdressDaoImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			logger.error("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public void deleteAdress(int id) {

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			CustomerAddress adress = (CustomerAddress) session.get(CustomerAddress.class, id);
			session.delete(adress);
			tx.commit();
			// logger.info("Deleted successfully.... ");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List getAdressById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<CustomerAddress> results = new ArrayList<CustomerAddress>();
		try {
			tx = session.beginTransaction();
			String hql = "FROM CustomerAdress WHERE adressId = :id";
			System.out.println("ID is " + id);
			Query query = session.createQuery(hql);
			query.setParameter("id", id);

			List<CustomerAddress> list = query.list();
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
	public List getAdress() {
		Session session = factory.openSession();
		Transaction tx = null;
		List adress = null;
		try {
			tx = session.beginTransaction();
			adress = session.createQuery("FROM CustomerAddress ").list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return adress;

	}

	@Override
	public void updateAdress(int id, CustomerAddress adress) {
		// TODO Auto-generated method stub

	}

	public void addAddress(CustomerAddress adress) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(adress);
			tx.commit();
			// logger.info("Added Successfully");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
