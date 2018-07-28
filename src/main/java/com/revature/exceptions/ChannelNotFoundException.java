package com.revature.exceptions;

public class ChannelNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ChannelNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChannelNotFoundException(String message) {
		super(message);
	}

	public ChannelNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
