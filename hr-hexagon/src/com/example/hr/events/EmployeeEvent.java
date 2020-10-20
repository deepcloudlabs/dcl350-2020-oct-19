package com.example.hr.events;

import com.example.hr.core.domain.Employee;

public class EmployeeEvent {
	private final String target;
	private final Employee employee;

	public EmployeeEvent(String target, Employee employee) {
		this.target = target;
		this.employee = employee;
	}

	public String getTarget() {
		return target;
	}

	public Employee getEmployee() {
		return employee;
	}

}
