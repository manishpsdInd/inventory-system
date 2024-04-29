package com.ecom.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {

	void processOrder(List<Map<String, Object>> message);

}
