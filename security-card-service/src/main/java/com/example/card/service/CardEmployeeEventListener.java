package com.example.card.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CardEmployeeEventListener {
	
	@KafkaListener(topics="hr")
	public void listenEvents(String event) {
		System.err.println(event);
	}
}
