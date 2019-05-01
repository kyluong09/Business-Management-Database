package com.business.management.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.business.management.entity.Role;
import com.business.management.entity.User;

public interface UserService extends UserDetailsService{
	
	public User findByUsername(String username);
	
	public void saveUser(User user);

	public Role findByRole(String name);
}
