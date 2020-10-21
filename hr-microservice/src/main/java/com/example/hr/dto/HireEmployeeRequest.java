package com.example.hr.dto;

import com.example.hr.core.domain.Department;
import com.example.hr.core.domain.Employee;
import com.example.hr.core.domain.FiatCurrency;
import com.example.hr.core.domain.Identity;

public class HireEmployeeRequest {
	private String identity;
	private String firstName;
	private String lastName;
	private double salary;
	private FiatCurrency currency;
	private String iban;
	private int birthYear;
	private String photo;
	private boolean fulltime;
	private Department department;

	public HireEmployeeRequest() {
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public FiatCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(FiatCurrency currency) {
		this.currency = currency;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "HireEmployeeRequest [identity=" + identity + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + ", currency=" + currency + ", iban=" + iban + ", birthYear=" + birthYear
				+ ", fulltime=" + fulltime + ", department=" + department + "]";
	}

	public Employee toEmployee() {
		return new Employee.Builder(Identity.valueOf(this.identity))
				          .fullname(firstName, lastName)
				          .iban(iban)
				          .salary(salary, currency)
				          .birthYear(birthYear)
				          .photo(photo.getBytes())
				          .fulltime(fulltime)
				          .department(department)
				          .build();
	}

}
