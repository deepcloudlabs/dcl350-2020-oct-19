package com.example.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// -Duser.language=tr -Duser.country=UK
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CrmMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmMicroserviceApplication.class, args);
	}

}
