package com.example.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.example.hr.core.domain.Department;
import com.example.hr.core.domain.FiatCurrency;

@Entity // (1)
@Table(name = "employees")
public class EmployeeEntity {
	@Id // (2)
	@Column(name = "tc_kimlik_no")
	private String identity;
	@Column(name = "ad")
	private String firstName;
	@Column(name = "soyad")
	private String lastName;
	@Column(name = "maas")
	private double salary;
	@Column(name = "para_birimi")
	@Enumerated(EnumType.STRING)
	private FiatCurrency currency;
	private String iban;
	@Column(name = "yil")
	private int birthYear;
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] photo;
	@Column(name = "tam_zamanli")
	private boolean fulltime;
	@Enumerated(EnumType.STRING)
	private Department department;

	public EmployeeEntity() {
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeEntity other = (EmployeeEntity) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [identity=" + identity + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + ", currency=" + currency + ", iban=" + iban + ", birthYear=" + birthYear
				+ ", fulltime=" + fulltime + ", department=" + department + "]";
	}

}
