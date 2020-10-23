package com.example.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.document.Customer;
import com.example.crm.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customers")
public class CustomerReactiveController {
	@Autowired private CustomerService customerService;

	@GetMapping("{identity}") // async
	public Mono<Customer> findByIdentity(@PathVariable String identity) {
		return customerService.findCustomerByIdentity(identity);
	}
	
	@GetMapping(params = {"page", "size"}) // async
	public Flux<Customer> findByPage(@RequestParam int page,@RequestParam int size) {
		return customerService.findCustomersByPage(page,size);
	}
}
