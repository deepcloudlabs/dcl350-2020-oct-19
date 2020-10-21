package com.example.crm.service.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crm.dto.AddCustomerRequest;
import com.example.crm.dto.AddCustomerResponse;
import com.example.crm.dto.CustomerResponse;
import com.example.crm.dto.UpdateCustomerRequest;
import com.example.crm.dto.UpdateCustomerResponse;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.service.CrmService;

@Service
public class SimpleCrmService implements CrmService {
    @Autowired private CustomerRepository customerRepository;
    
	@Override
	public CustomerResponse findById(String identity) {
		return customerRepository.findById(identity)
				     .map( customer -> );
	}

	@Override
	public List<CustomerResponse> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddCustomerResponse create(AddCustomerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCustomerResponse update(UpdateCustomerRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCustomerResponse patch(Map<String, Object> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerResponse delete(String identity) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
