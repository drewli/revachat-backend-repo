package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Invite;
import com.revature.beans.InviteErrorResponse;
import com.revature.exceptions.InviteNotFoundException;
import com.revature.services.InviteService;

@CrossOrigin
@RestController
@RequestMapping(value="/invites")
public class InviteController {


	@Autowired
	InviteService inviteService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Invite> getAllInvites(){
		System.out.println("LOG - in InviteController.getAllInvites");
		return inviteService.getAll();
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Invite getById(@PathVariable int id) {

		Invite invite = inviteService.getById(id);	

		if(invite == null) {
			throw new InviteNotFoundException("Invite with id: " + id + " not found");
		}

		return invite;
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Invite> addInvite(@RequestBody Invite invite) {
		Invite newInvite= inviteService.addInvite(invite);
		return new ResponseEntity<Invite>(newInvite, HttpStatus.CREATED);
	}

	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Invite> updateInvite(@RequestBody Invite invite ){
		Invite updatedInvite = inviteService.updateInvite(invite);

		if(updatedInvite == null) {
			throw new InviteNotFoundException("Invite with id+ " + invite.getInviteId() + " not found");
		}

		return new ResponseEntity<Invite>(updatedInvite, HttpStatus.OK);

	}


	@DeleteMapping(value="/{id}")
	public ResponseEntity<Invite> deleteInvite(@PathVariable int id) {
		System.out.println("LOG - In InviteController.deleteInvite()...");
		int deleted = inviteService.deleteInvite(id);
		
		if(deleted == -1) {
			throw new InviteNotFoundException("Invite with id " + id + " not found");
		}
		return new ResponseEntity<Invite>(HttpStatus.OK); 
	}
	
	
	@ExceptionHandler
	public ResponseEntity<InviteErrorResponse> inviteNotFound(InviteNotFoundException e){
		
		InviteErrorResponse cer = new InviteErrorResponse();
		
		cer.setMessage(e.getMessage());
		cer.setStatusCode(HttpStatus.NOT_FOUND.value());
		cer.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<InviteErrorResponse>(cer, HttpStatus.NOT_FOUND);
	}

}
