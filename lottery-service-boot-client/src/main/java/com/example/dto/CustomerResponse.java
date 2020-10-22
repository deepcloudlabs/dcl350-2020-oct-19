package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResponse {
	@JsonProperty("tc_kimlik_no")
	private String identity;
	@JsonProperty("ad_soyad")
	private String fullname;
	private String sms;
	@JsonProperty("eposta")
	private String email;

	public CustomerResponse() {
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

	@Override
	public String toString() {
		return "CustomerResponse [identity=" + identity + ", fullname=" + fullname + ", sms=" + sms + ", email=" + email
				+ "]";
	}

}
