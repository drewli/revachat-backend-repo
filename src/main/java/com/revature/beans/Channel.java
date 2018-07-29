package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="CHANNELS")
@SequenceGenerator(name="channelSeq", sequenceName="CHANNEL_SEQ", allocationSize=1)
public class Channel {
	@Id
	@Column(name="CHANNEL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="channelSeq")
	private int channelId;
	
	@Column(name="CHANNEL_DIRECT_MESSAGING")
	private String isDirectMessaging;
	
	@Column(name="CHANNEL_NAME")
	private String channelName;
	
	public Channel() {
		super();
	}

	public Channel(String isDirectMessaging, String channelName) {
		super();
		this.isDirectMessaging = isDirectMessaging;
		this.channelName = channelName;
	}

	public Channel(int channelId, String isDirectMessaging, String channelName) {
		super();
		this.channelId = channelId;
		this.isDirectMessaging = isDirectMessaging;
		this.channelName = channelName;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getIsDirectMessaging() {
		return isDirectMessaging;
	}

	public void setIsDirectMessaging(String isDirectMessaging) {
		this.isDirectMessaging = isDirectMessaging;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + channelId;
		result = prime * result + ((channelName == null) ? 0 : channelName.hashCode());
		result = prime * result + ((isDirectMessaging == null) ? 0 : isDirectMessaging.hashCode());
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
		Channel other = (Channel) obj;
		if (channelId != other.channelId)
			return false;
		if (channelName == null) {
			if (other.channelName != null)
				return false;
		} else if (!channelName.equals(other.channelName))
			return false;
		if (isDirectMessaging == null) {
			if (other.isDirectMessaging != null)
				return false;
		} else if (!isDirectMessaging.equals(other.isDirectMessaging))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", isDirectMessaging=" + isDirectMessaging + ", channelName="
				+ channelName + "]";
	}
	
	
	
}