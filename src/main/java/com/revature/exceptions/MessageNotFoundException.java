package com.revature.exceptions;

public class MessageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MessageNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageNotFoundException(String message) {
		super(message);
	}

	public MessageNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
