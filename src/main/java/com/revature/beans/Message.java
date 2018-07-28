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
@Table(name="MESSAGES")
@SequenceGenerator(name="messageSeq", sequenceName="MESSAGE_SEQ", allocationSize=1)
public class Message {

	@Id
	@Column(name="MESSAGE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="messageSeq")
	private int message_id;

	@Column(name="MESSAGE")
	private String message;

	@Column(name="MESSAGE_USER_ID")
	private String message_user_id;

	@Column(name="MESAGE_CHANNEL_ID")
	private String message_channel_id;

	public Message() {}

	public Message(int message_id, String message, String message_user_id, String message_channel_id) {
		super();
		this.message_id = message_id;
		this.message = message;
		this.message_user_id = message_user_id;
		this.message_channel_id = message_channel_id;
	}

	public Message(String message, String message_user_id, String message_channel_id) {
		super();
		this.message = message;
		this.message_user_id = message_user_id;
		this.message_channel_id = message_channel_id;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage_user_id() {
		return message_user_id;
	}

	public void setMessage_user_id(String message_user_id) {
		this.message_user_id = message_user_id;
	}

	public String getMessage_channel_id() {
		return message_channel_id;
	}

	public void setMessage_channel_id(String message_channel_id) {
		this.message_channel_id = message_channel_id;
	}

	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", message=" + message + ", message_user_id=" + message_user_id
				+ ", message_channel_id=" + message_channel_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((message_channel_id == null) ? 0 : message_channel_id.hashCode());
		result = prime * result + message_id;
		result = prime * result + ((message_user_id == null) ? 0 : message_user_id.hashCode());
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
		Message other = (Message) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (message_channel_id == null) {
			if (other.message_channel_id != null)
				return false;
		} else if (!message_channel_id.equals(other.message_channel_id))
			return false;
		if (message_id != other.message_id)
			return false;
		if (message_user_id == null) {
			if (other.message_user_id != null)
				return false;
		} else if (!message_user_id.equals(other.message_user_id))
			return false;
		return true;
	}

}
