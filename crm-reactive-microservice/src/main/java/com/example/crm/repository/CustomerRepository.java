package com.example.crm.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.crm.document.Customer;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

}
