package com.revature.exceptions;

public class InviteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InviteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public InviteNotFoundException(String message) {
		super(message);
	}

	public InviteNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
