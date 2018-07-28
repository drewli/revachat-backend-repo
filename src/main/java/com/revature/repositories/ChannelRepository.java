package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Channel;

@Repository
public class ChannelRepository {

	@Autowired
	SessionFactory sessionFactory;

	public List<Channel> getAllChannels(){	
		System.out.println("LOG - in ChanelRep.getAllChannels");
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("from Channel", Channel.class).getResultList();
	}

	public Channel getChannelById(int channelId) {
		System.out.println("LOG - in ChanelRep.getChannelById");
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Channel.class, channelId);	
	}

	public Channel addChannel(Channel channel) {
		System.out.println("LOG - in ChanelRep.addChannel");
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(channel);
		return channel;
	}

	public Channel updateChannel(Channel updatedChannel) {
		System.out.println("LOG - in ChanelRep.updateChannel");
		Session currentSession = sessionFactory.getCurrentSession();
		Channel channel = currentSession.get(Channel.class, updatedChannel.getchannel_id());

		if(channel == null) {
			return channel;
		}

		else {
			channel = updatedChannel;
			return channel;
		}
	}

	public int deleteChannel(int id) {
		System.out.println("LOG - in ChanelRep.deleteChannel");
		Session currentSession = sessionFactory.getCurrentSession();
		Channel channelCheck = currentSession.get(Channel.class, id);

		if(channelCheck == null) {
			return -1;
		} else {
			currentSession.delete(channelCheck);
			return 1;
		}
	}

}
