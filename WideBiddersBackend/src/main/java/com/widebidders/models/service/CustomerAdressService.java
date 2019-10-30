package com.widebidders.models.service;

import java.util.List;

import com.widebidders.models.entities.CustomerAddress;

public interface CustomerAdressService {

	public void deleteAdress(int id);

	public List<CustomerAddress> getAdressById(int id);

	public List<CustomerAddress> getAdress();

	public void addAddress(CustomerAddress adress);

	public void updateAdress(int id, CustomerAddress customer);

}
