package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.beans.UserErrorResponse;
import com.revature.exceptions.UserNotFoundException;
import com.revature.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {


	@Autowired
	UserService UserService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		System.out.println("LOG - in UserController.getAllUsers");
		return UserService.getAll();
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public User getById(int id) {

		User User = UserService.getById(id);	

		if(User == null) {
			throw new UserNotFoundException("User with id: " + id + " not found");
		}

		return User;
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User User) {
		User newUser= UserService.addUser(User);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}

	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User User ){
		User updatedUser = UserService.updateUser(User);

		if(updatedUser == null) {
			throw new UserNotFoundException("User with id+ " + User.getUserId() + " not found");
		}

		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);

	}


	@DeleteMapping(value="/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		System.out.println("LOG - In UserController.deleteUser()...");
		int deleted = UserService.deleteUser(id);
		
		if(deleted == -1) {
			throw new UserNotFoundException("User with id " + id + " not found");
		}
		return new ResponseEntity<User>(HttpStatus.OK); 
	}
	
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> UserNotFound(UserNotFoundException e){
		
		UserErrorResponse cer = new UserErrorResponse();
		
		cer.setMessage(e.getMessage());
		cer.setStatusCode(HttpStatus.NOT_FOUND.value());
		cer.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<UserErrorResponse>(cer, HttpStatus.NOT_FOUND);
	}

}


