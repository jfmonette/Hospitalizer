package ca.uqam.mgl7460.a2011.hospitalizer.domain;

import ca.uqam.mgl7460.a2011.hospitalizer.data.Persistable;

public class Address extends Persistable {
	private String civicNumber = "";
	private String street = "";
	private String city = "";
	private String province = "";
	private String postalCode = "";
	
	public Address() {};
	
	public Address(String civicNumber, String street, String city,
			String province, String postalCode) {
		super();
		this.civicNumber = civicNumber;
		this.street = street;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}
	public String getCivicNumber() {
		return civicNumber;
	}
	public void setCivicNumber(String civicNumber) {
		this.civicNumber = civicNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
