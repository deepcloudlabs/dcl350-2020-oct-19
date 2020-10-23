package com.example.hr.events;

import com.example.hr.core.domain.Employee;

public class EmployeeEvent {
	private String target;
	private Employee employee;

	public EmployeeEvent(String target, Employee employee) {
		this.target = target;
		this.employee = employee;
	}

	public EmployeeEvent() {
	}

	public String getTarget() {
		return target;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
