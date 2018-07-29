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
@Table(name="INVITES")
@SequenceGenerator(name="inviteSeq", sequenceName="INVITE_SEQ", allocationSize=1)
public class Invite {
	@Id
	@Column(name="INVITE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="inviteSeq")
	private int inviteId;
	
	@Column(name="INVITED_USER_ID")
	private int invitedUserId;

	@Column(name="INVITE_CHANNEL_ID")
	private int inviteChannelId;

	public Invite() {
		super();
	}

	public Invite(int invitedUserId, int inviteChannelId) {
		super();
		this.invitedUserId = invitedUserId;
		this.inviteChannelId = inviteChannelId;
	}

	public Invite(int inviteId, int invitedUserId, int inviteChannelId) {
		super();
		this.inviteId = inviteId;
		this.invitedUserId = invitedUserId;
		this.inviteChannelId = inviteChannelId;
	}

	public int getInviteId() {
		return inviteId;
	}

	public void setInviteId(int inviteId) {
		this.inviteId = inviteId;
	}

	public int getInvitedUserId() {
		return invitedUserId;
	}

	public void setInvitedUserId(int invitedUserId) {
		this.invitedUserId = invitedUserId;
	}

	public int getInviteChannelId() {
		return inviteChannelId;
	}

	public void setInviteChannelId(int inviteChannelId) {
		this.inviteChannelId = inviteChannelId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inviteChannelId;
		result = prime * result + inviteId;
		result = prime * result + invitedUserId;
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
		Invite other = (Invite) obj;
		if (inviteChannelId != other.inviteChannelId)
			return false;
		if (inviteId != other.inviteId)
			return false;
		if (invitedUserId != other.invitedUserId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invite [inviteId=" + inviteId + ", invitedUserId=" + invitedUserId + ", inviteChannelId="
				+ inviteChannelId + "]";
	}
	

}
