package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Message;
import com.revature.beans.MessageErrorResponse;
import com.revature.exceptions.MessageNotFoundException;
import com.revature.services.MessageService;

@RestController
@RequestMapping(value="/messages")
public class MessageController {


	@Autowired
	MessageService messageService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Message> getAllMessages(){
		System.out.println("LOG - in MessageController.getAllMessages");
		return messageService.getAll();
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Message getById(int id) {

		Message message = messageService.getById(id);	

		if(message == null) {
			throw new MessageNotFoundException("Message with id: " + id + " not found");
		}

		return message;
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> addMessage(@RequestBody Message message) {
		Message newMessage= messageService.addMessage(message);
		return new ResponseEntity<Message>(newMessage, HttpStatus.CREATED);
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateMessage(@RequestBody Message message ){
		Message updatedMessage = messageService.updateMessage(message);

		if(updatedMessage == null) {
			throw new MessageNotFoundException("Message with id+ " + message.getMessage_id() + " not found");
		}

		return new ResponseEntity<Message>(updatedMessage, HttpStatus.OK);

	}


	@DeleteMapping(value="/{id}")
	public ResponseEntity<Message> deleteMessage(@PathVariable int id) {
		System.out.println("LOG - In MessageController.deleteMessage()...");
		int deleted = messageService.deleteMessage(id);
		
		if(deleted == -1) {
			throw new MessageNotFoundException("Message with id " + id + " not found");
		}
		return new ResponseEntity<Message>(HttpStatus.OK); 
	}
	
	
	@ExceptionHandler
	public ResponseEntity<MessageErrorResponse> messageNotFound(MessageNotFoundException e){
		
		MessageErrorResponse cer = new MessageErrorResponse();
		
		cer.setMessage(e.getMessage());
		cer.setStatusCode(HttpStatus.NOT_FOUND.value());
		cer.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<MessageErrorResponse>(cer, HttpStatus.NOT_FOUND);
	}

}
