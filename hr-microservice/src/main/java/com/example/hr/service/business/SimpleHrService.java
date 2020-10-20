package com.example.hr.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.application.HrApplication;
import com.example.hr.core.domain.Employee;
import com.example.hr.core.domain.Identity;
import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.example.hr.service.HrService;

@Service
public class SimpleHrService implements HrService {
	@Autowired
	private HrApplication hrApplication;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		Employee employee = null;
		hrApplication.hireEmployee(employee);
		//TODO: Convert request to employee
		return new HireEmployeeResponse();
	}

	@Override
	@Transactional
	public FireEmployeeResponse fireEmployee(String identity) {
		var employee = hrApplication.fireEmployee(Identity.valueOf(identity));
		if (employee.isEmpty())
			throw new IllegalArgumentException("Cannot find employee to fire.");
		//TODO: Convert employee to FireEmployeeResponse
		return new FireEmployeeResponse();
	}

}
