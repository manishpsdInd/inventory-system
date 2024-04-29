package com.ecom.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.payment.dto.PaymentRequest;
import com.ecom.payment.dto.PaymentResponse;
import com.ecom.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@PostMapping("/create")
	public PaymentResponse createPayment(@RequestBody PaymentRequest request)	{
		return service.createpayment(request);
	}
	
	@PostMapping("/get")
	public PaymentResponse getPaymentDetails(@RequestBody PaymentRequest request)	{
		return service.getPaymentDetails(request);
	}
	
}
