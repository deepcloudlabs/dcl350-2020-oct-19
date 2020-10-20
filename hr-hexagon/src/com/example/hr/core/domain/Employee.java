package com.example.hr.core.domain;

// DDD : Entity, Value Object, Aggregate
// Aggregate -> Entity Class -> Persist, Identity, Mutable
public class Employee {
	private final Identity identity;
	private Fullname fullname;
	private Money salary;
	private Iban iban;
	private BirthYear birthYear;
	private Photo photo;
	private boolean fulltime;
	private Department department;

	// Alt+Shift+S : Generate Source
	// Ctrl+Shift+O: Organize import
	// Ctrl + 1: code generate
	// Ctrl + Shift + F: Format source

	public Employee(Identity identity, Fullname fullname, BirthYear birthYear) {
		this.identity = identity;
		this.fullname = fullname;
		this.birthYear = birthYear;
	}

	public Employee(Identity identity, Fullname fullname, Money salary, Iban iban, BirthYear birthYear, Photo photo,
			Department department) {
		this.identity = identity;
		this.fullname = fullname;
		this.salary = salary;
		this.iban = iban;
		this.birthYear = birthYear;
		this.photo = photo;
		this.department = department;
	}

	public Employee(Identity identity, Fullname fullname, Money salary, Iban iban, BirthYear birthYear, Photo photo,
			Department department, boolean fulltime) {
		this(identity, fullname, salary, iban, birthYear, photo, department);
		this.fulltime = fulltime;
	}

	public Employee(Builder builder) {
		this(builder.identity, builder.fullname, builder.birthYear);
		this.setDepartment(builder.department);
		this.setPhoto(builder.photo);
		this.setIban(builder.iban);
		this.setSalary(builder.salary);
		this.setFulltime(builder.fulltime);
	}

	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
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

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(BirthYear birthYear) {
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

	public static class Builder {
		private final Identity identity;
		private Fullname fullname;
		private Money salary;
		private Iban iban;
		private boolean fulltime;
		private BirthYear birthYear;
		private Photo photo;
		private Department department;

		public Builder(Identity identity) {
			this.identity = identity;
		}

		public Builder fullname(String first, String last) {
			this.fullname = new Fullname(first, last);
			return this;
		}

		public Builder salary(double value, FiatCurrency currency) {
			this.salary = Money.valueOf(value, currency);
			return this;
		}

		public Builder iban(String value) {
			this.iban = Iban.valueOf(value);
			return this;
		}

		public Builder fulltime(boolean value) {
			this.fulltime = value;
			return this;
		}

		public Builder birthYear(int value) {
			this.birthYear = BirthYear.valueOf(value);
			return this;
		}

		public Builder photo(byte[] values) {
			this.photo = Photo.valueOf(values);
			return this;
		}

		public Builder department(Department department) {
			this.department = department;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}

}
