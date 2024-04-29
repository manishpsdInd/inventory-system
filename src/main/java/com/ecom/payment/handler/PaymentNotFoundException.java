package com.ecom.payment.handler;

public class PaymentNotFoundException extends RuntimeException	{

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	
	public PaymentNotFoundException() {
		super();
	}
	
	public PaymentNotFoundException(String message) {
		super(message);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
