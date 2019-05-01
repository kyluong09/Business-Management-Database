package com.business.management.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.business.management.dao.RoleRepository;
import com.business.management.dao.UserRepository;
import com.business.management.entity.Role;
import com.business.management.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		 if(user == null) {
			 throw new UsernameNotFoundException("User not found by name: "+ username);
		 }
		
		 // Use GrantAuthority for multiple roles from single user
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
		
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

		
	}
	
	@Override
	public Role findByRole(String name) {
		return roleRepository.findByName(name);
	}
	
	
	/**
	 * Find user by username
	 */
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	/**
	 * Save user data to database
	 */
	@Override
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(1);
		Role role = roleRepository.findByName("USER");
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}
	
	

}
