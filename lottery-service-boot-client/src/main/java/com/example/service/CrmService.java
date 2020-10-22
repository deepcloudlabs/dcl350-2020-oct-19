package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.CustomerResponse;

@FeignClient("crm")
public interface CrmService {
	@GetMapping("/crm/api/v1/customers/{identity}")
	public CustomerResponse findCustomer(@PathVariable String identity);
}
