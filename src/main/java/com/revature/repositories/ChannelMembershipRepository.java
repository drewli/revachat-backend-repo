package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.ChannelMembership;

@Repository
public class ChannelMembershipRepository {

	@Autowired
	SessionFactory sessionFactory;

	public List<ChannelMembership> getAllChannelMemberships(){	
		System.out.println("LOG - in ChannelMembershipRep.getAllChannelMemberships");
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from ChannelMembership", ChannelMembership.class).getResultList();
	}

	public ChannelMembership getChannelMembershipById(int channelMembershipId) {
		System.out.println("LOG - in ChannelMembershipRep.getChannelMembershipById");
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(ChannelMembership.class, channelMembershipId);	
	}

	public ChannelMembership addChannelMembership(ChannelMembership channelMembership) {
		System.out.println("LOG - in ChannelMembershipRep.addChannelMembership");
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(channelMembership);
		return channelMembership;
	}

	public ChannelMembership updateChannelMembership(ChannelMembership updatedChannelMembership) {
		System.out.println("LOG - in ChannelMembershipRep.updateChannelMembership");
		Session currentSession = sessionFactory.getCurrentSession();
		ChannelMembership channelMembership = currentSession.get(ChannelMembership.class, updatedChannelMembership.getChannelMembershipId());

		if(channelMembership == null) {
			return channelMembership;
		}

		else {
			channelMembership = updatedChannelMembership;
			currentSession.merge(channelMembership);
			return channelMembership;
		}
	}

	public int deleteChannelMembership(int id) {
		System.out.println("LOG - in ChannelMembershipRep.deleteChannelMembership");
		Session currentSession = sessionFactory.getCurrentSession();
		ChannelMembership channelMembershipCheck = currentSession.get(ChannelMembership.class, id);

		if(channelMembershipCheck == null) {
			return -1;
		} else {
			currentSession.delete(channelMembershipCheck);
			return 1;
		}
	}

}
