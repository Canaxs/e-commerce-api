package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.User;

public interface UserJpaRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);

}
