package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.core.domain.Employee;
import com.example.hr.core.domain.Identity;
import com.example.hr.events.EmployeeFiredEvent;
import com.example.hr.events.EmployeeHiredEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class SimpleHrApplication implements HrApplication {

	private EmployeeRepository employeeRepository; // SPI #1
	private EventPublisher eventPublisher; // SPI #2

	// Constructor Injection
	public SimpleHrApplication(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public boolean hireEmployee(Employee employee) {
		var identity = employee.getIdentity();
		if (employeeRepository.existsByIdentity(identity))
			throw new IllegalArgumentException("Employee already exists");
		employeeRepository.create(employee);
		eventPublisher.publishEvent(new EmployeeHiredEvent("employees",employee));
		return true;
	}

	@Override
	public Optional<Employee> fireEmployee(Identity identity) {
		if (!employeeRepository.existsByIdentity(identity))
			return Optional.empty();
		var employee = employeeRepository.removeByIdentity(identity);
		eventPublisher.publishEvent(new EmployeeFiredEvent("employees",employee));
		return Optional.of(employee);
	}

}
