package com.ecom.user.handler;

public class InvalidUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;

	public InvalidUserException() {
			super();
		}

	public InvalidUserException(String message) {
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
