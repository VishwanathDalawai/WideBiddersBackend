<<<<<<< HEAD
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
=======
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
>>>>>>> 3c6820757d04c2a0e46684bcb8857b89d63569b1
