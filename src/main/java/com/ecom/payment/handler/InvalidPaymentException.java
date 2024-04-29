package com.ecom.payment.handler;

public class InvalidPaymentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;

	public InvalidPaymentException() {
			super();
		}

	public InvalidPaymentException(String message) {
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
