package com.business.management.dao;

import org.springframework.data.repository.CrudRepository;

import com.business.management.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);

}
