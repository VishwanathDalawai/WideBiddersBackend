package com.widebidders.models.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.widebidders.models.db.CustomerAdressDaoImpl;
import com.widebidders.models.entities.CustomerAddress;


@Service
public class CustomerAdressServiceImpl implements CustomerAdressService {

	private SessionFactory factory;

	private static final Logger logger = LoggerFactory.getLogger(CustomerAdressDaoImpl.class);
	
	@Autowired
	private CustomerAdressDaoImpl adressDboImpl;



	@Override
	public void deleteAdress(int id) {
		adressDboImpl.deleteAdress(id);
	}

	@Override
	public List getAdressById(int id) {
				return adressDboImpl.getAdressById(id);
	}

	@Override
	public List getAdress() {
		
		return adressDboImpl.getAdress();
	}

	@Override
	public void addAddress(CustomerAddress adress) {
		adressDboImpl.addAddress(adress);

	}

	@Override
	public void updateAdress(int id, CustomerAddress customer) {
		adressDboImpl.updateAdress(id, customer);
		

	}

}
