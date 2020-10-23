package com.example.hr.events;

import com.example.hr.core.domain.Employee;

public class EmployeeFiredEvent extends EmployeeEvent {

	public EmployeeFiredEvent() {

	}

	public EmployeeFiredEvent(String target, Employee employee) {
		super(target, employee);
	}

}
