package com.business.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.management.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);

}
