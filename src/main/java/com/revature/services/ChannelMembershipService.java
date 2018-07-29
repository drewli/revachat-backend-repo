package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.ChannelMembership;
import com.revature.repositories.ChannelMembershipRepository;

@Service
@Transactional
public class ChannelMembershipService {
	static {
		System.out.println("[DEBUG] - ChannelMembershipService instantiated...");
	}
	
	@Autowired
	ChannelMembershipRepository channelMembershipRepo;
	
	public List<ChannelMembership> getAll() {
		System.out.println("[DEBUG] - In ChannelMembershipService.getAll()...");
		return channelMembershipRepo.getAllChannelMemberships();
	}
	
	public ChannelMembership getById(int id) {
		System.out.println("[DEBUG] - In ChannelMembershipService.getById()...");
		return channelMembershipRepo.getChannelMembershipById(id);
	}
	
	public ChannelMembership addChannelMembership(ChannelMembership channelMembership) {
		System.out.println("[DEBUG] - In ChannelMembershipService.addChannelMembership()...");
		return channelMembershipRepo.addChannelMembership(channelMembership);
	}

	public ChannelMembership updateChannelMembership(ChannelMembership channelMembership) {
		System.out.println("[DEBUG] - In ChannelMembershipService.updateChannelMembership()...");
		return channelMembershipRepo.updateChannelMembership(channelMembership);
	}
	
	public int deleteChannelMembership(int id) {
		System.out.println("[DEBUG] - In ChannelMembershipService.deleteChannelMembership()...");
		return channelMembershipRepo.deleteChannelMembership(id);
	}
	
}
