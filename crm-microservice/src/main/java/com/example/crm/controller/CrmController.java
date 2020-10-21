package com.example.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.crm.dto.AddCustomerRequest;
import com.example.crm.dto.AddCustomerResponse;
import com.example.crm.dto.CustomerResponse;
import com.example.crm.dto.UpdateCustomerRequest;
import com.example.crm.dto.UpdateCustomerResponse;
import com.example.crm.service.CrmService;

// REST over HTTP -> Capabilities: Http Methods: {GET, POST, PUT, PATCH, DELETE}, OPTION, HEAD
// Resource -> Model -> Customer (Entity Root -> Aggregate) -> URL
@RestController                        // application.properties ==|               ==|  @RequestMapping
@RequestScope                          //                          V                 V
@RequestMapping("customers") // Customer -> URL: http://localhost:6200/crm/api/v1/customers
@CrossOrigin
public class CrmController {
	
	@Autowired private CrmService crmService;
	
    @GetMapping("{identity}")
    public CustomerResponse findCustomerByIdentity(@PathVariable String identity) {
    	return crmService.findById(identity);
    }
    
    @GetMapping(params = {"page", "size"})
    public List<CustomerResponse> findCustomersByPagination(
    		@RequestParam(required = false, defaultValue = "0") int page,
    		@RequestParam(required = false, defaultValue = "25") int size){
    	return crmService.findByPage(page,size);
    }
    
    @PostMapping
    public AddCustomerResponse addCustomer(@RequestBody AddCustomerRequest request) {
    	return crmService.create(request);
    }
    
    // PUT http://localhost:6200/crm/api/v1/customers/11111111110
    @PutMapping("{identity}")
    public UpdateCustomerResponse updateCustomer(
    		@PathVariable String identity,
    		@RequestBody UpdateCustomerRequest request) {
    	return crmService.update(identity, request);
    }
    
    @PatchMapping("{identity}")
    public UpdateCustomerResponse updateCustomer(
    		@PathVariable String identity,
    		@RequestBody Map<String,Object> request) {
    	return crmService.patch(identity, request);    	
    }
    
    @DeleteMapping("{identity}")
    public CustomerResponse removeCustomerByIdentity(@PathVariable String identity) {
    	return crmService.delete(identity);
    }
    
}
