package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public class UserRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public User addUser(User newUser){
		System.out.println("LOG - In UserRepository.addUser");
		Session session = sessionFactory.getCurrentSession();
		session.save(newUser);
		return newUser;
	}

	
	/*
	updateUser(FlashCard)

	deleteUser(int)	
	
	getAllUsers()

	getUserById(int)
*/


}
