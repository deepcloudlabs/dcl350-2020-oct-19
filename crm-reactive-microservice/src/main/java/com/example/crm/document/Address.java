package com.example.crm.document;

public class Address {
	private String city;
	private String country;
	private String line;
	private String zipCode;
	private AddressType type;

	public Address() {
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", line=" + line + ", zipCode="
				+ zipCode + ", type=" + type + "]";
	}

}
