package com.ecom.payment.reopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.payment.entity.PaymentEntity;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{

	public PaymentEntity findByTransactionId(String transactionId);	
}
