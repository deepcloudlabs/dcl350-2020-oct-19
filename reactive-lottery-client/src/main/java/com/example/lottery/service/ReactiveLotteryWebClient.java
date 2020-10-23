package com.example.lottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ReactiveLotteryWebClient {
	private static final String URL = "http://localhost:8100/lottery/api/v1/numbers?column=10";
	
	@Autowired
	private WebClient webClient;
	
	@Scheduled(fixedRate = 1_000)
	public void reactiveClientCall() {
	    	webClient.get()
	    	         .uri(URL)
	    	         .header("Accept", "application/json")
	    	         .retrieve()
	    	         .bodyToMono(String.class)
	    	         .subscribe(System.out::println,System.err::println);
	}
}
