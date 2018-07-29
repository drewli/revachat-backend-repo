package com.revature.exceptions;

public class ChannelMembershipNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ChannelMembershipNotFoundException(String channelMembership, Throwable cause) {
		super(channelMembership, cause);
	}

	public ChannelMembershipNotFoundException(String channelMembership) {
		super(channelMembership);
	}

	public ChannelMembershipNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
