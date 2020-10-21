package com.example.hr.dto;

public class HireEmployeeResponse {

	private String status;
	private String identity;

	public HireEmployeeResponse(String status, String identity) {
		this.status = status;
		this.identity = identity;
	}

	public String getStatus() {
		return status;
	}

	public String getIdentity() {
		return identity;
	}

}
