package com.example.crm.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.crm.document.Customer;

import reactor.core.publisher.Flux;

// http://binkurt.blogspot.com/2015/02/mongodb-ile-calsmak.html
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
	@Query("{}")
	Flux<Customer> findAll(PageRequest request);

}
