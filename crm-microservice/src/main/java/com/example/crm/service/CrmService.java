package com.example.crm.service;

import java.util.List;
import java.util.Map;

import com.example.crm.dto.AddCustomerRequest;
import com.example.crm.dto.AddCustomerResponse;
import com.example.crm.dto.CustomerResponse;
import com.example.crm.dto.UpdateCustomerRequest;
import com.example.crm.dto.UpdateCustomerResponse;

public interface CrmService {

	CustomerResponse findById(String identity);

	List<CustomerResponse> findByPage(int page, int size);

	AddCustomerResponse create(AddCustomerRequest request);

	UpdateCustomerResponse update(String identity, UpdateCustomerRequest request);

	UpdateCustomerResponse patch(String identity, Map<String, Object> request);

	CustomerResponse delete(String identity);

}
