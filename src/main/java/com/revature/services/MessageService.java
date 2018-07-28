package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Message;
import com.revature.repositories.MessageRepository;

@Service
@Transactional
public class MessageService {
	static {
		System.out.println("[DEBUG] - MessageService instantiated...");
	}
	
	@Autowired
	MessageRepository messageRepo;
	
	public List<Message> getAll() {
		System.out.println("[DEBUG] - In MessageService.getAll()...");
		return messageRepo.getAllMessages();
	}
	
	public Message getById(int id) {
		System.out.println("[DEBUG] - In MessageService.getById()...");
		return messageRepo.getMessageById(id);
	}
	
	public Message addMessage(Message message) {
		System.out.println("[DEBUG] - In MessageService.addMessage()...");
		return messageRepo.addMessage(message);
	}

	public Message updateMessage(Message Message) {
		System.out.println("[DEBUG] - In MessageService.updateMessage()...");
		return messageRepo.updateMessage(Message);
	}
	
	public int deleteMessage(int id) {
		System.out.println("[DEBUG] - In MessageService.deleteMessage()...");
		return messageRepo.deleteMessage(id);
	}
	
}
