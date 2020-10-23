package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.events.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;

@Service
public class EventPublisherAdapter implements EventPublisher {
    @Autowired 
    private KafkaTemplate<String, EmployeeEvent> publisher;
    
	@Override
	public void publishEvent(EmployeeEvent employeeEvent) {
		publisher.send("hr", employeeEvent);
	}

}
