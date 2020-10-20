package com.example.hr.adapter;

import org.springframework.stereotype.Repository;

import com.example.hr.core.domain.Employee;
import com.example.hr.core.domain.Identity;
import com.example.hr.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryAdapter implements EmployeeRepository {

	@Override
	public boolean existsByIdentity(Identity identity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void create(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee removeByIdentity(Identity identity) {
		// TODO Auto-generated method stub
		return null;
	}

}
