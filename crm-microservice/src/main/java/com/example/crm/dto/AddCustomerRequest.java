package com.example.crm.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.crm.entity.Address;
import com.example.validation.Email;
import com.example.validation.TcKimlikNo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddCustomerRequest {
	@JsonProperty("tc_kimlik_no")
	@TcKimlikNo
	private String identity;
	@JsonProperty("ad_soyad")
	@Size(min=6)
	private String fullname;
	@Pattern(regexp="^\\d+$")
	private String sms;
	@JsonProperty("eposta")
	@Email
	private String email;
	@NotNull
	private String photo;
	private List<Address> addresses;

	public AddCustomerRequest() {
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "AddCustomerRequest [identity=" + identity + ", fullname=" + fullname + ", sms=" + sms + ", email="
				+ email + ", addresses=" + addresses + "]";
	}

}
