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

	public List<User> getAll() {
		System.out.println("[DEBUG] - In UserRepository.getAll()...");
		Session s  = sessionFactory.getCurrentSession();
		return s.createQuery("from User", User.class).getResultList();
	}
	
	public User getById(int id) {
		System.out.println("[DEBUG] - In UserRepository.getById()...");
		Session s  = sessionFactory.getCurrentSession();
		return s.get(User.class, id);
	}
	
	public User addUser(User newUser){
		System.out.println("[DEBUG] - In UserRepository.addUser");
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
