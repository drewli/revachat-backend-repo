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
@Table(name="CHANNEL")
@SequenceGenerator(name="channelSeq", sequenceName="CHANNEL_SEQ", allocationSize=1)
public class Channel {

	public Channel() {}
	
	public Channel(int channel_id, String channel_name, String channel_creator_id) {
		super();
		this.channel_id = channel_id;
		this.channel_name = channel_name;
		this.channel_creator_id = channel_creator_id;
	}

	
	
	public Channel(String channel_name, String channel_creator_id) {
		super();
		this.channel_name = channel_name;
		this.channel_creator_id = channel_creator_id;
	}


	@Id
	@Column(name="CHANNEL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="channelSeq")
	private int channel_id;

	@Column(name="CHANNEL_NAME")
	private String channel_name;

	
	@Column(name="CHANNEL_CREATOR_ID")
	private String channel_creator_id;

	public int getchannel_id() {
		return channel_id;
	}

	public void setchannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	public String getchannel_name() {
		return channel_name;
	}

	public void setchannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	public String getChannel_creator_id() {
		return channel_creator_id;
	}

	public void setChannel_creator_id(String channel_creator_id) {
		this.channel_creator_id = channel_creator_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + ((channel_creator_id == null) ? 0 : channel_creator_id.hashCode());
		result = prime * result + channel_id;
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
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (channel_creator_id == null) {
			if (other.channel_creator_id != null)
				return false;
		} else if (!channel_creator_id.equals(other.channel_creator_id))
			return false;
		if (channel_id != other.channel_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Channel [channel_id=" + channel_id + ", channel_name=" + channel_name + ", channel_creator_id="
				+ channel_creator_id + "]";
	}

	
	
	
}