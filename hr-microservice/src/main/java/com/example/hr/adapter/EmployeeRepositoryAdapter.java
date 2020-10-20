package com.example.hr.adapter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.core.domain.Employee;
import com.example.hr.core.domain.Identity;
import com.example.hr.entity.EmployeeEntity;
import com.example.hr.repository.EmployeeEntityRepository;
import com.example.hr.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryAdapter implements EmployeeRepository {
	@Autowired
	private EmployeeEntityRepository empRepo;

	@Override
	public boolean existsByIdentity(Identity identity) {
		return empRepo.existsById(identity.getValue());
	}

	@Override
	@Transactional
	public void create(Employee employee) {
		// TODO: convert Employee to EmployeeEntity
		EmployeeEntity ee = null;
		empRepo.save(ee);
	}

	@Override
	@Transactional
	public Employee removeByIdentity(Identity identity) {
		Optional<EmployeeEntity> employeeEntity = empRepo.findById(identity.getValue());
		if (employeeEntity.isEmpty())
			throw new IllegalArgumentException("Cannot find employee to delete.");
		EmployeeEntity entity = employeeEntity.get();
		empRepo.delete(entity);
		//TODO: Convert EmployeeEntity to Employee
		Employee employee = null;
		return employee;
	}

}
