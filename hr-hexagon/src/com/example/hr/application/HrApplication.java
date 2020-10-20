package com.example.hr.application;

import java.util.Optional;

import com.example.hr.core.domain.Employee;
import com.example.hr.core.domain.Identity;

// Cohesion ✔ -> Single Responsibility Principle ✔ -> Interface Segregation Principle
//               Single Business Capability 
public interface HrApplication {
	boolean hireEmployee(Employee employee);
	Optional<Employee> fireEmployee(Identity identity);
}
