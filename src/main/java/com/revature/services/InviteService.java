package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Invite;
import com.revature.repositories.InviteRepository;

@Service
@Transactional
public class InviteService {
	static {
		System.out.println("[DEBUG] - InviteService instantiated...");
	}
	
	@Autowired
	InviteRepository inviteRepo;
	
	public List<Invite> getAll() {
		System.out.println("[DEBUG] - In InviteService.getAll()...");
		return inviteRepo.getAllInvites();
	}
	
	public Invite getById(int id) {
		System.out.println("[DEBUG] - In InviteService.getById()...");
		return inviteRepo.getInviteById(id);
	}
	
	public Invite addInvite(Invite invite) {
		System.out.println("[DEBUG] - In InviteService.addInvite()...");
		return inviteRepo.addInvite(invite);
	}

	public Invite updateInvite(Invite invite) {
		System.out.println("[DEBUG] - In InviteService.updateInvite()...");
		return inviteRepo.updateInvite(invite);
	}
	
	public int deleteInvite(int id) {
		System.out.println("[DEBUG] - In InviteService.deleteInvite()...");
		return inviteRepo.deleteInvite(id);
	}
	
}
