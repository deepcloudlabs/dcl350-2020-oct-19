package com.example.client;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

@Service
public class StudyClientSideLoadBalancing2 {
	private static final String URL = "http://%s:%d/lottery/api/v1/numbers?column=10";

	@Autowired private DiscoveryClient discoveryClient;
	private BaseLoadBalancer loadBalancer;
	
	@PostConstruct
	public void initLoadBalancer() {
		List<Server> servers = 
				discoveryClient.getInstances("lottery")
				               .stream()
				               .map( si -> new Server(si.getHost(), si.getPort()))
				               .collect(Collectors.toList());      
		IRule roundRobinRule = new RoundRobinRule(); 
		loadBalancer = LoadBalancerBuilder.newBuilder()
		                   .withRule(roundRobinRule)
		                   .buildFixedServerListLoadBalancer(servers);    
	}
	
	@Scheduled(fixedRate = 3_000)
	public void callLotteryService() {
		var restTemplate = new RestTemplate();
		Server server = loadBalancer.chooseServer();
		String formattedUrl = String.format(URL,server .getHost(),server.getPort());
		var response = restTemplate.getForEntity(formattedUrl, String.class).getBody();
		System.err.println(formattedUrl+" (#2) : "+response);
	}
}
