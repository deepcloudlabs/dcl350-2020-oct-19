package com.example.client;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.Ticker;

@Service
public class LotteryClientService {
	private static final String URL1 = "http://localhost:8100/lottery/api/v1/numbers?column=10";
	private static final String URL2 = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";

	@Scheduled(fixedRate = 3_000)
	public void callLotteryService() {
		var restTemplate = new RestTemplate();
		var response = restTemplate.getForEntity(URL1, String.class).getBody();
		System.err.println(response);
	}
	
	//@Scheduled(fixedRate = 3_000)
	public void callBinanceService() {
		var restTemplate = new RestTemplate();
		var ticker = restTemplate.getForEntity(URL2, Ticker.class).getBody();
		System.err.println(ticker);
	}
}
