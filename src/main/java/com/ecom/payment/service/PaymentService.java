package com.ecom.payment.service;

import com.ecom.payment.dto.PaymentRequest;
import com.ecom.payment.dto.PaymentResponse;

public interface PaymentService {

	public PaymentResponse createpayment(PaymentRequest request);
	public PaymentResponse getPaymentDetails(PaymentRequest request);
	
}
