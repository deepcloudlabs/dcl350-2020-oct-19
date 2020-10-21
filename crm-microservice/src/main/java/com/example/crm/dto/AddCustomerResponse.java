package com.example.crm.dto;

public class AddCustomerResponse {

	private final String status;

	public AddCustomerResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
