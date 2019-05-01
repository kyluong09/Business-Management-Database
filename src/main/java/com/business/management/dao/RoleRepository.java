package com.business.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.management.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByName(String name);

}
