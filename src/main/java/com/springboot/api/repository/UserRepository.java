package com.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findById(long id);
}
