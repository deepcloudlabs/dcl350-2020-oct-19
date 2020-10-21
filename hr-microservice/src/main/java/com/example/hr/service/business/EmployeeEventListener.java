package com.example.hr.service.business;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.hr.events.EmployeeEvent;

@Service
public class EmployeeEventListener {

	@EventListener
	public void listenEmployeeEvent(EmployeeEvent event) {
		System.err.println("Event has arrived: "+event.getClass().getName());
	}
}
