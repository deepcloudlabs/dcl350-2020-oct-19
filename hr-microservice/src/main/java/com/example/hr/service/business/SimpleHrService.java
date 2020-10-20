package com.example.hr.service.business;

import org.springframework.stereotype.Service;

import com.example.hr.dto.FireEmployeeResponse;
import com.example.hr.dto.HireEmployeeRequest;
import com.example.hr.dto.HireEmployeeResponse;
import com.example.hr.service.HrService;

@Service
public class SimpleHrService implements HrService {

	@Override
	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FireEmployeeResponse fireEmployee(String identity) {
		// TODO Auto-generated method stub
		return null;
	}

}
