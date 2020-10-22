package com.example.binance.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LotteryApiAsyncHttpClient {

	private static final String URL = "http://localhost:8100/lottery/api/v1/numbers?column=10";

	public static void main(String[] args) throws IOException, InterruptedException {
		var counter = new AtomicInteger(0);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
				.uri(URI.create(URL))
				.header("Accept", "application/json")
				.build();
		var start = System.currentTimeMillis();
		for (var i=0;i<10;++i) {
			// asynchronous -> non-blocking
			client.sendAsync(request, HttpResponse.BodyHandlers.ofString()) 
					             .thenAccept( ticker -> {
					            	 if(counter.incrementAndGet()==10) {
					            		 var stop = System.currentTimeMillis();
					            		 System.err.println("Duration: "+(stop-start)+" ms.");
					            	 }
					            	 System.err.println(Thread.currentThread().getName()+": "+ticker.body());								            	 
					             });
		}
		System.err.println("exited from for loop...");
		TimeUnit.SECONDS.sleep(5);
	}

}
