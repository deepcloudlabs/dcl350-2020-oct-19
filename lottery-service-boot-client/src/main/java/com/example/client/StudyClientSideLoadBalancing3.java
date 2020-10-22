package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudyClientSideLoadBalancing3 {
	private static final String SERVICE_NAME= "//lottery";
	private static final String URL = SERVICE_NAME + "/lottery/api/v1/numbers?column=10";
	@Autowired private RestTemplate restTemplate;
	
	@Scheduled(fixedRate = 2_000)
	public void callLotteryService() {
		var response = restTemplate.getForEntity(URL, String.class).getBody();
		System.err.println(" (#3) : "+response);
	}
}
