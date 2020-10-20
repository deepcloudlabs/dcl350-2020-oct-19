package com.example.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.SimpleHrApplication;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

@Configuration
public class AppConfig {

	@Bean
	public HrApplication hrApplication(
			EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
		return new SimpleHrApplication(employeeRepository, eventPublisher);
	}
}
