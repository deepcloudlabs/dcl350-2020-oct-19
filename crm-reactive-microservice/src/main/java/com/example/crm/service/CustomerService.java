package com.example.crm.service;

import com.example.crm.document.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

	Mono<Customer> findCustomerByIdentity(String identity);

	Flux<Customer> findCustomersByPage(int page, int size);

}
