package com.example.crm.service.business;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.crm.dto.AddCustomerRequest;
import com.example.crm.dto.AddCustomerResponse;
import com.example.crm.dto.CustomerResponse;
import com.example.crm.dto.UpdateCustomerRequest;
import com.example.crm.dto.UpdateCustomerResponse;
import com.example.crm.entity.Customer;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.service.CrmService;

@Service
public class SimpleCrmService implements CrmService {
    @Autowired private CustomerRepository customerRepository;
    @Autowired private ModelMapper modelMapper;
    
	@Override
	public CustomerResponse findById(String identity) {
		return customerRepository.findById(identity)
				     .map(this::convertCustomerToCustomerReponse )
				     .orElseThrow(() -> new IllegalArgumentException("Cannot find customer"));
	}

	@Override
	public List<CustomerResponse> findByPage(int page, int size) {
		return customerRepository.findAll(PageRequest.of(page, size))
				.getContent()
				.stream()
				.map(this::convertCustomerToCustomerReponse)
				.collect(toList());
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
	
    private CustomerResponse convertCustomerToCustomerReponse(Customer customer) {
    	return modelMapper.map(customer,CustomerResponse.class);
    }
}
