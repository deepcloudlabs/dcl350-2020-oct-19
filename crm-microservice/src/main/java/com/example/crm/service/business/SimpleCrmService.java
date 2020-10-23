package com.example.crm.service.business;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerResponse findById(String identity) {
		return customerRepository.findById(identity).map(this::convertCustomerToCustomerReponse)
				.orElseThrow(() -> new IllegalArgumentException("Cannot find customer"));
	}

	@Override
	public List<CustomerResponse> findByPage(int page, int size) {
		return customerRepository.findAll(PageRequest.of(page, size)).getContent().stream()
				.map(this::convertCustomerToCustomerReponse).collect(toList());
	}

	@Override
	@Transactional
	public AddCustomerResponse create(AddCustomerRequest request) {
		var identity = request.getIdentity();
		if (customerRepository.existsById(identity))
			throw new IllegalArgumentException("Customer already exists.");
		Customer customer = modelMapper.map(request, Customer.class);
		System.err.println("Before save...");
		customerRepository.save(customer);
		customerRepository.flush();
		System.err.println("After save...");
		return new AddCustomerResponse("ok");
	}

	@Override
	@Transactional
	public UpdateCustomerResponse update(String identity, UpdateCustomerRequest request) {
		var managedCustomer = customerRepository.findById(identity);
		if (Objects.isNull(managedCustomer))
			throw new IllegalArgumentException("Customer does not exist to update.");
		Customer customer = modelMapper.map(request, Customer.class);
		var cust = managedCustomer.get();
		cust.setEmail(customer.getEmail());
		cust.setSms(customer.getSms());
		cust.getAddresses().clear();
		cust.getAddresses().addAll(customer.getAddresses());
		cust.setFullname(customer.getFullname());
		cust.setPhoto(customer.getPhoto());
		customerRepository.save(cust);
		return new UpdateCustomerResponse("ok");
	}

	@Override
	@Transactional
	public UpdateCustomerResponse patch(String identity, Map<String, Object> request) {
		var managedCustomer = customerRepository.findById(identity);
		if (Objects.isNull(managedCustomer))
			throw new IllegalArgumentException("Customer does not exist to patch.");
		var cust = managedCustomer.get();
		var clazz = Customer.class;
		request.forEach((key, value) -> {
			try {
				var field = clazz.getDeclaredField(key);
				if (Objects.nonNull(field)) {
					field.setAccessible(true);
					field.set(cust, value);
					field.setAccessible(false);
				}
			} catch (Exception e) {
				System.err.println("Error has occured: " + e.getMessage());
			}
		});
		return new UpdateCustomerResponse("ok");
	}

	@Override
	@Transactional
	public CustomerResponse delete(String identity) {
		var managedCustomer = customerRepository.findById(identity);
		if (Objects.isNull(managedCustomer))
			throw new IllegalArgumentException("Customer does not exist to patch.");
		var cust = managedCustomer.get();
		customerRepository.delete(cust);
		return modelMapper.map(cust, CustomerResponse.class);
	}

	private CustomerResponse convertCustomerToCustomerReponse(Customer customer) {
		return modelMapper.map(customer, CustomerResponse.class);
	}

}
