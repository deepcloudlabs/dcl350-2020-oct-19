package com.example.hr.core.domain;

@SuppressWarnings("unused")
public class TestEmployee {

	public static void main(String[] args) {
		var jack2 = new Employee( // Constructor
					Identity.valueOf("11111111110"), 
					new Fullname("jack", "bauer"), 
					Money.valueOf(100000, FiatCurrency.USD), 
					Iban.valueOf("tr1"), 
					BirthYear.valueOf(1956), 
					Photo.valueOf("".getBytes()), 
					Department.IT
				);
		var jack =
				new Employee.Builder(Identity.valueOf("11111111110"))
				   .department(Department.IT)
				   .iban("tr1")
				   .salary(100000, FiatCurrency.USD)
				   .photo("".getBytes())
				   .fullname("jack", "bauer")
				   .fulltime(true)
				   .birthYear(1956)
				   .build();

	}

}
