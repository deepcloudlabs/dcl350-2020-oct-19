package com.example.hr.events;

import com.example.hr.core.domain.Employee;

public class EmployeeHiredEvent extends EmployeeEvent {

	public EmployeeHiredEvent() {
	}

	public EmployeeHiredEvent(String target, Employee employee) {
		super(target, employee);
	}

}
