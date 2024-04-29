package com.ecom.order.listener;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ecom.order.service.OrderService;

@Component
public class OrderListener {

	private static final Logger log = Logger.getLogger(OrderListener.class.getName());
	
	@Autowired
	private OrderService service;
	
	@KafkaListener(topics = "NewTopic", groupId = "order-service-group")
	public void consume(List<Map<String,Object>> message) {
		
		service.processOrder(message);
		log.info("message = " + message);
	}

}
