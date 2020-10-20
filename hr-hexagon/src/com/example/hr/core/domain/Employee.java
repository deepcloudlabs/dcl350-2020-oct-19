package com.example.hr.core.domain;

// DDD : Entity, Value Object, Aggregate
// Entity Class -> Persist, Identity, Mutable
public class Employee {
	private final Identity identity;
	private Fullname fullname;
	private Money salary;
	private Iban iban;
	private BirtyYear birthYear;
	private Photo photo;
	private Department department;

	// Alt+Shift+S : Generate Source
	// Ctrl+Shift+O: Organize import
	// Ctrl + 1: code generate
	// Ctrl + Shift + F: Format source

	public Employee(Identity identity, Fullname fullname, BirtyYear birthYear) {
		this.identity = identity;
		this.fullname = fullname;
		this.birthYear = birthYear;
	}

	public Employee(Identity identity, Fullname fullname, Money salary, Iban iban, BirtyYear birthYear, Photo photo,
			Department department) {
		this.identity = identity;
		this.fullname = fullname;
		this.salary = salary;
		this.iban = iban;
		this.birthYear = birthYear;
		this.photo = photo;
		this.department = department;
	}

	public Fullname getFullname() {
		return fullname;
	}

	public void setFullname(Fullname fullname) {
		this.fullname = fullname;
	}

	public Money getSalary() {
		return salary;
	}

	public void setSalary(Money salary) {
		this.salary = salary;
	}

	public Iban getIban() {
		return iban;
	}

	public void setIban(Iban iban) {
		this.iban = iban;
	}

	public BirtyYear getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(BirtyYear birthYear) {
		this.birthYear = birthYear;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Identity getIdentity() {
		return identity;
	}

	//TODO: Builder pattern
	
	
}
