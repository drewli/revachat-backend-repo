package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="CHANNEL_MEMBERSHIPS")
@SequenceGenerator(name="channelMembershipSeq", sequenceName="CHANNEL_MEMBERSHIP_SEQ", allocationSize=1)
public class ChannelMembership {
	@Id
	@Column(name="CHANNEL_MEMBERSHIP_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="channelMembershipSeq")
	private int channelMembershipId;
	
	@Column(name="CHANNEL_USER_ID")
	private int channelUserId;
	
	@Column(name="CHANNEL_USER_ROLE")
	private String channelUserRole;
	
	@Column(name="CHANNEL_ID")
	private int channelId;

	public ChannelMembership() {
		super();
	}

	public ChannelMembership(int channelUserId, String channelUserRole, int channelId) {
		super();
		this.channelUserId = channelUserId;
		this.channelUserRole = channelUserRole;
		this.channelId = channelId;
	}

	public ChannelMembership(int channelMembershipId, int channelUserId, String channelUserRole, int channelId) {
		super();
		this.channelMembershipId = channelMembershipId;
		this.channelUserId = channelUserId;
		this.channelUserRole = channelUserRole;
		this.channelId = channelId;
	}

	public int getChannelMembershipId() {
		return channelMembershipId;
	}

	public void setChannelMembershipId(int channelMembershipId) {
		this.channelMembershipId = channelMembershipId;
	}

	public int getChannelUserId() {
		return channelUserId;
	}

	public void setChannelUserId(int channelUserId) {
		this.channelUserId = channelUserId;
	}

	public String getChannelUserRole() {
		return channelUserRole;
	}

	public void setChannelUserRole(String channelUserRole) {
		this.channelUserRole = channelUserRole;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + channelId;
		result = prime * result + channelMembershipId;
		result = prime * result + channelUserId;
		result = prime * result + ((channelUserRole == null) ? 0 : channelUserRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChannelMembership other = (ChannelMembership) obj;
		if (channelId != other.channelId)
			return false;
		if (channelMembershipId != other.channelMembershipId)
			return false;
		if (channelUserId != other.channelUserId)
			return false;
		if (channelUserRole == null) {
			if (other.channelUserRole != null)
				return false;
		} else if (!channelUserRole.equals(other.channelUserRole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChannelMembership [channelMembershipId=" + channelMembershipId + ", channelUserId=" + channelUserId
				+ ", channelUserRole=" + channelUserRole + ", channelId=" + channelId + "]";
	}
	
	
}
