package com.ecom.payment.service.impl;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.payment.dto.PaymentRequest;
import com.ecom.payment.dto.PaymentResponse;
import com.ecom.payment.entity.PaymentEntity;
import com.ecom.payment.handler.PaymentNotFoundException;
import com.ecom.payment.reopsitory.PaymentRepository;
import com.ecom.payment.service.PaymentService;

import jakarta.transaction.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService	{

	@Autowired
	private PaymentRepository repository;
	
	@Transactional
	@Override
	public PaymentResponse createpayment(PaymentRequest request) {
		
		// TODO Call to Payment Gateway
		String transactionId = String.valueOf(Math.random());
		
		PaymentEntity entity = new PaymentEntity();
		entity.setPaymentCountry(request.getPaymentCountry());
		entity.setPaymentCurrency(request.getPaymentCurrency());
		entity.setPaymentDate(request.getPaymentDate());
		entity.setPaymentMode(request.getPaymentMode());
		entity.setPaymentStatus(request.getPaymentStatus());
		entity.setTransactionId(transactionId);

		PaymentEntity data = repository.getReferenceById(request.getPaymentId());
		if(data != null){
			throw new InvalidParameterException("Payment data in invalid");
		}
		data = repository.save(entity);
		
		PaymentResponse response = new PaymentResponse();
		response.setPaymentId(data.getPaymentId());
		response.setPaymentStatus(data.getPaymentStatus());
		response.setPaymentStatus(data.getPaymentStatus());
		
		return response;
	}

	@Override
	public PaymentResponse getPaymentDetails(PaymentRequest request) {
		
		PaymentEntity data = repository.getReferenceById(request.getPaymentId());
		PaymentResponse response = new PaymentResponse();
		
		if(data == null){
			throw new PaymentNotFoundException("Invalid Payment Id Passed");
		} else {
			response.setPaymentId(data.getPaymentId());
			response.setPaymentStatus(data.getPaymentStatus());
			response.setPaymentStatus(data.getPaymentStatus());
		}
		
		return response;
	}

}