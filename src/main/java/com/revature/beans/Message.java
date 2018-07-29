package com.revature.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

// import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
@Table(name="MESSAGES")
@SequenceGenerator(name="messageSeq", sequenceName="MESSAGE_SEQ", allocationSize=1)
public class Message {

	@Id
	@Column(name="MESSAGE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="messageSeq")
	private int messageId;

	@Column(name="MESSAGE_CONTENT")
	private String messageContent;

	@Column(name="MESSAGE_SENDER_ID")
	private int messageSenderId;

	@Column(name="MESSAGE_CHANNEL_ID")
	private int messageChannelId;
	
	@Column(name="MESSAGE_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	// @JsonFormat(pattern="EEE MMM dd yyyy HH:mm:ss \'GMT\'Z \'(\'z\')\'")
	private Date messageTimestamp;

	public Message() {
		super();
	}

	public Message(String messageContent, int messageSenderId, int messageChannelId, Date messageTimestamp) {
		super();
		this.messageContent = messageContent;
		this.messageSenderId = messageSenderId;
		this.messageChannelId = messageChannelId;
		this.messageTimestamp = messageTimestamp;
	}

	public Message(int messageId, String messageContent, int messageSenderId, int messageChannelId,
			Date messageTimestamp) {
		super();
		this.messageId = messageId;
		this.messageContent = messageContent;
		this.messageSenderId = messageSenderId;
		this.messageChannelId = messageChannelId;
		this.messageTimestamp = messageTimestamp;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public int getMessageSenderId() {
		return messageSenderId;
	}

	public void setMessageSenderId(int messageSenderId) {
		this.messageSenderId = messageSenderId;
	}

	public int getMessageChannelId() {
		return messageChannelId;
	}

	public void setMessageChannelId(int messageChannelId) {
		this.messageChannelId = messageChannelId;
	}

	public java.util.Date getMessageTimestamp() {
		return messageTimestamp;
	}

	public void setMessageTimestamp(java.util.Date messageTimestamp) {
		this.messageTimestamp = messageTimestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + messageChannelId;
		result = prime * result + ((messageContent == null) ? 0 : messageContent.hashCode());
		result = prime * result + messageId;
		result = prime * result + messageSenderId;
		result = prime * result + ((messageTimestamp == null) ? 0 : messageTimestamp.hashCode());
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
		if (messageChannelId != other.messageChannelId)
			return false;
		if (messageContent == null) {
			if (other.messageContent != null)
				return false;
		} else if (!messageContent.equals(other.messageContent))
			return false;
		if (messageId != other.messageId)
			return false;
		if (messageSenderId != other.messageSenderId)
			return false;
		if (messageTimestamp == null) {
			if (other.messageTimestamp != null)
				return false;
		} else if (!messageTimestamp.equals(other.messageTimestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageContent=" + messageContent + ", messageSenderId="
				+ messageSenderId + ", messageChannelId=" + messageChannelId + ", messageTimestamp=" + messageTimestamp
				+ "]";
	}
	
	
	
	
}
