package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Invite;

@Repository
public class InviteRepository {

	@Autowired
	SessionFactory sessionFactory;

	public List<Invite> getAllInvites(){	
		System.out.println("LOG - in InviteRep.getAllInvites");
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from Invite", Invite.class).getResultList();
	}

	public Invite getInviteById(int inviteId) {
		System.out.println("LOG - in InviteRep.getInviteById");
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Invite.class, inviteId);	
	}

	public Invite addInvite(Invite invite) {
		System.out.println("LOG - in InviteRep.addInvite");
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(invite);
		return invite;
	}

	public Invite updateInvite(Invite updatedInvite) {
		System.out.println("LOG - in InviteRep.updateInvite");
		Session currentSession = sessionFactory.getCurrentSession();
		Invite invite = currentSession.get(Invite.class, updatedInvite.getInviteId());

		if(invite == null) {
			return invite;
		}

		else {
			invite = updatedInvite;
			currentSession.merge(invite);
			return invite;
		}
	}

	public int deleteInvite(int id) {
		System.out.println("LOG - in InviteRep.deleteInvite");
		Session currentSession = sessionFactory.getCurrentSession();
		Invite inviteCheck = currentSession.get(Invite.class, id);

		if(inviteCheck == null) {
			return -1;
		} else {
			currentSession.delete(inviteCheck);
			return 1;
		}
	}

}
