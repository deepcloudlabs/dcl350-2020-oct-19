package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.core.domain.Employee;
import com.example.hr.core.domain.Identity;

public class SimpleHrApplication implements HrApplication {

	@Override
	public boolean hireEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Employee> fireEmployee(Identity identity) {
		// TODO Auto-generated method stub
		return null;
	}

}
