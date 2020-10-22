package com.example.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// set PATH=c:\DEVEL\stage\opt\curl-7.45.0\bin;%PATH%
// curl -X POST localhost:8100/lottery/api/v1/actuator/refresh -d {} -H "Content-Type: application/json"

@SpringBootApplication
public class LotteryCloudNativeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryCloudNativeServiceApplication.class, args);
	}

}
