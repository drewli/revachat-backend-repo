package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;
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
	
	public User updateUser(User updatedUser) {
		System.out.println("LOG - in UserRep.updateUser");
		Session currentSession = sessionFactory.getCurrentSession();
		User User = currentSession.get(User.class, updatedUser.getUser_id());
		
		if(User == null) {
			return User;
		}

		else {
			User = updatedUser;
			return User;
		}
	}

	public int deleteUser(int id) {
		System.out.println("LOG - in UserRep.deleteUser");
		Session currentSession = sessionFactory.getCurrentSession();
		User UserCheck = currentSession.get(User.class, id);

		if(UserCheck == null) {
			return -1;
		} else {
			currentSession.delete(UserCheck);
			return 1;
		}
	}



}
