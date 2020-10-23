package com.example.client;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

@Service
public class LotteryAsyncClientService {
	@Scheduled(fixedRate = 3_000)
	public void asyncCallToLotteryService() {
		  var art = new AsyncRestTemplate();
		  art.getForEntity("http://localhost:8100/lottery/api/v1/numbers?column=10", String.class)
		     .addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {

				@Override
				public void onSuccess(ResponseEntity<String> result) {
					System.err.println("Async response: "+result.getBody());
				}

				@Override
				public void onFailure(Throwable ex) {
					System.err.println(ex.getMessage());	
				}
			});
	}
}
