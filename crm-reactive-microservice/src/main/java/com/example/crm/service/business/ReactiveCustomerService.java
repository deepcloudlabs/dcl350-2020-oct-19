package com.example.crm.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.crm.document.Customer;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveCustomerService implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Mono<Customer> findCustomerByIdentity(String identity) {
		return customerRepository.findById(identity);
	}

	@Override
	public Flux<Customer> findCustomersByPage(int page, int size) {
		return customerRepository.findAll(PageRequest.of(page, size));
	}

}
