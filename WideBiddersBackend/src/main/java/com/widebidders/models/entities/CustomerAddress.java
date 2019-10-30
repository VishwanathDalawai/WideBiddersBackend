package com.widebidders.models.entities;

public class CustomerAddress {

	private int adressId;
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	private String addressType;
	private int houseNumbre;

	public CustomerAddress() {

	}

	public CustomerAddress(int adressId, String addressType, int houseNumbre, String streetName, int pincode,
			String preferredAddress, int customerId) {

		this.adressId = adressId;
		this.addressType = addressType;
		this.houseNumbre = houseNumbre;
		this.streetName = streetName;
		this.pincode = pincode;
		this.preferredAddress = preferredAddress;
		this.customerId = customerId;
	}

	public int getAdressId() {
		return adressId;
	}

	public void setAdressId(int adressId) {
		this.adressId = adressId;

	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public int getHouseNumbre() {
		return houseNumbre;
	}

	public void setHouseNumbre(int houseNumbre) {
		this.houseNumbre = houseNumbre;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPreferredAddress() {
		return preferredAddress;
	}

	public void setPreferredAddress(String preferredAddress) {
		this.preferredAddress = preferredAddress;
	}

	private String streetName;
	private int pincode;
	private String preferredAddress;

}
