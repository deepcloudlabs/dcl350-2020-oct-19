package com.example.hr.repository;

import com.example.hr.core.domain.Employee;
import com.example.hr.core.domain.Identity;

public interface EmployeeRepository {

	boolean existsByIdentity(Identity identity);

	void create(Employee employee);

	Employee removeByIdentity(Identity identity);

}
