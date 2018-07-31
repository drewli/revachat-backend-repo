package com.revature.exceptions;

public class UserCreationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserCreationException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserCreationException(String message) {
		super(message);
	}

	public UserCreationException(Throwable cause) {
		super(cause);
	}

}