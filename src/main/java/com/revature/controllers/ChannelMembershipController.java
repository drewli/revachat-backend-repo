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

import com.revature.beans.ChannelMembership;
import com.revature.beans.ChannelMembershipErrorResponse;
import com.revature.exceptions.ChannelMembershipNotFoundException;
import com.revature.services.ChannelMembershipService;

@CrossOrigin
@RestController
@RequestMapping(value="/channel-memberships")
public class ChannelMembershipController {


	@Autowired
	ChannelMembershipService channelMembershipService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ChannelMembership> getAllChannelMemberships(){
		System.out.println("LOG - in ChannelMembershipController.getAllChannelMemberships");
		return channelMembershipService.getAll();
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ChannelMembership getById(@PathVariable int id) {

		ChannelMembership channelMembership = channelMembershipService.getById(id);	

		if(channelMembership == null) {
			throw new ChannelMembershipNotFoundException("ChannelMembership with id: " + id + " not found");
		}

		return channelMembership;
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChannelMembership> addChannelMembership(@RequestBody ChannelMembership channelMembership) {
		ChannelMembership newChannelMembership= channelMembershipService.addChannelMembership(channelMembership);
		return new ResponseEntity<ChannelMembership>(newChannelMembership, HttpStatus.CREATED);
	}

	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChannelMembership> updateChannelMembership(@RequestBody ChannelMembership channelMembership ){
		ChannelMembership updatedChannelMembership = channelMembershipService.updateChannelMembership(channelMembership);

		if(updatedChannelMembership == null) {
			throw new ChannelMembershipNotFoundException("ChannelMembership with id+ " + channelMembership.getChannelMembershipId() + " not found");
		}

		return new ResponseEntity<ChannelMembership>(updatedChannelMembership, HttpStatus.OK);

	}


	@DeleteMapping(value="/{id}")
	public ResponseEntity<ChannelMembership> deleteChannelMembership(@PathVariable int id) {
		System.out.println("LOG - In ChannelMembershipController.deleteChannelMembership()...");
		int deleted = channelMembershipService.deleteChannelMembership(id);
		
		if(deleted == -1) {
			throw new ChannelMembershipNotFoundException("ChannelMembership with id " + id + " not found");
		}
		return new ResponseEntity<ChannelMembership>(HttpStatus.OK); 
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ChannelMembershipErrorResponse> channelMembershipNotFound(ChannelMembershipNotFoundException e){
		
		ChannelMembershipErrorResponse cer = new ChannelMembershipErrorResponse();
		
		cer.setMessage(e.getMessage());
		cer.setStatusCode(HttpStatus.NOT_FOUND.value());
		cer.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ChannelMembershipErrorResponse>(cer, HttpStatus.NOT_FOUND);
	}

}
