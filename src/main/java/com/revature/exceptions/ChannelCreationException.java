package com.revature.exceptions;

public class ChannelCreationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ChannelCreationException() {
		super();
	}

	public ChannelCreationException(String message) {
		super(message);
	}

	public ChannelCreationException(Throwable cause) {
		super(cause);
	}
	
	

}
