package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Message;

@Repository
public class MessageRepository {

	@Autowired
	SessionFactory sessionFactory;

	public List<Message> getAllMessages(){	
		System.out.println("LOG - in MessageRep.getAllMessages");
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from Message", Message.class).getResultList();
	}

	public Message getMessageById(int messageId) {
		System.out.println("LOG - in messageRep.getMessageById");
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Message.class, messageId);	
	}

	public Message addMessage(Message message) {
		System.out.println("LOG - in messageRep.addMessage");
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(message);
		return message;
	}

	public Message updateMessage(Message updatedMessage) {
		System.out.println("LOG - in messageRep.updateMessage");
		Session currentSession = sessionFactory.getCurrentSession();
		Message message = currentSession.get(Message.class, updatedMessage.getMessage_id());

		if(message == null) {
			return message;
		}

		else {
			message = updatedMessage;
			return message;
		}
	}

	public int deleteMessage(int id) {
		System.out.println("LOG - in messageRep.deleteMessage");
		Session currentSession = sessionFactory.getCurrentSession();
		Message messageCheck = currentSession.get(Message.class, id);

		if(messageCheck == null) {
			return -1;
		} else {
			currentSession.delete(messageCheck);
			return 1;
		}
	}

}
