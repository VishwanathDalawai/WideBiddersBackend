package com.widebidders.models.db;

import java.util.List;

import com.widebidders.models.entities.CustomerAddress;

public interface CustomerAdressDao {
	public void deleteAdress(int id);

	public List getAdressById(int id);

	public List getAdress();

	public void updateAdress(int id, CustomerAddress adress);

	void addAddress(CustomerAddress adress);

}
