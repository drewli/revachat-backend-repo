package com.revature.controllers;

import java.sql.Timestamp;
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

import com.revature.beans.Channel;
import com.revature.beans.ChannelErrorResponse;
import com.revature.exceptions.ChannelNotFoundException;
import com.revature.services.ChannelService;

@RestController
@RequestMapping(value="/channels")
public class ChannelController {


	@Autowired
	ChannelService channelService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Channel> getAllChannels(){
		System.out.println("LOG - in ChannelController.getAllChannels");
		return channelService.getAll();
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Channel getById(int id) {

		Channel channel = channelService.getById(id);	

		if(channel == null) {
			throw new ChannelNotFoundException("Channel with id: " + id + " not found");
		}

		return channel;
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Channel> addChannel(@RequestBody Channel channel) {
		Channel newChannel= channelService.addChannel(channel);
		return new ResponseEntity<Channel>(newChannel, HttpStatus.CREATED);
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Channel> updateChannel(@RequestBody Channel channel ){
		Channel updatedChannel = channelService.updateChannel(channel);

		if(updatedChannel == null) {
			throw new ChannelNotFoundException("Channel with id+ " + updatedChannel.getchannel_id() + " not found");
		}

		return new ResponseEntity<Channel>(updatedChannel, HttpStatus.OK);

	}


	@DeleteMapping(value="/{id}")
	public ResponseEntity<Channel> deleteChannel(@PathVariable int id) {
		System.out.println("LOG - In ChannelController.deleteChannel()...");
		int deleted = channelService.deleteChannel(id);
		
		if(deleted == -1) {
			throw new ChannelNotFoundException("Channel with id " + id + " not found");
		}
		return new ResponseEntity<Channel>(HttpStatus.OK); 
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ChannelErrorResponse> channelNotFound(ChannelNotFoundException e){
		
		ChannelErrorResponse cer = new ChannelErrorResponse();
		
		cer.setMessage(e.getMessage());
		cer.setStatusCode(HttpStatus.NOT_FOUND.value());
		cer.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ChannelErrorResponse>(cer, HttpStatus.NOT_FOUND);
	}

}


