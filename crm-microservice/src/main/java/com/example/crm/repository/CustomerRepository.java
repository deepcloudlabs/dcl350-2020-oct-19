package com.example.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crm.entity.Customer;

// Ctrl + Shift + O
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
