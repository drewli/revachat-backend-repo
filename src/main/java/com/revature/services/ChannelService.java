package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Channel;
import com.revature.repositories.ChannelRepository;

@Service
@Transactional
public class ChannelService {
	static {
		System.out.println("[DEBUG] - ChannelService instantiated...");
	}
	
	@Autowired
	ChannelRepository ChannelRepo;
	
	public List<Channel> getAll() {
		System.out.println("[DEBUG] - In ChannelService.getAll()...");
		return ChannelRepo.getAllChannels();
	}
	
	public Channel getById(int id) {
		System.out.println("[DEBUG] - In ChannelService.getById()...");
		return ChannelRepo.getChannelById(id);
	}
	
	public Channel addChannel(Channel channel) {
		System.out.println("[DEBUG] - In ChannelService.addChannel()...");
		return ChannelRepo.addChannel(channel);
	}


	public Channel updateChannel(Channel channel) {
		System.out.println("[DEBUG] - In ChannelService.updateChannel()...");
		return ChannelRepo.updateChannel(channel);
	}
	
	public int deleteChannel(int id) {
		System.out.println("[DEBUG] - In ChannelService.deleteChannel()...");
		return ChannelRepo.deleteChannel(id);
	}
	
}
