package com.antawa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antawa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findOneByUsername(String username);
	
}
