package com.example.client;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudyClientSideLoadBalancing1 {
	private static final String URL = "http://%s:%d/lottery/api/v1/numbers?column=10";
	private final AtomicInteger counter = new AtomicInteger();

	@Autowired private DiscoveryClient discoveryClient;
	private List<ServiceInstance> servers;

	
	@PostConstruct
	public void getInstances() {
		// application.properties: spring.application.name=lottery
		servers = discoveryClient.getInstances("lottery");        
	}
	
	@Scheduled(fixedRate = 5_000)
	public void callLotteryService() {
		var restTemplate = new RestTemplate();
		int index = counter.getAndIncrement() % servers.size();
		ServiceInstance server = servers.get(index );
		String formattedUrl = String.format(URL,server .getHost(),server.getPort());
		var response = restTemplate.getForEntity(formattedUrl, String.class).getBody();
		System.err.println(formattedUrl+" (#1) : "+response);
	}
}
