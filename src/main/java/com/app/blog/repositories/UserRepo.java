package com.app.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.entities.User;

// adds user data to tables

public interface UserRepo extends JpaRepository<User, Integer> {
	

}
