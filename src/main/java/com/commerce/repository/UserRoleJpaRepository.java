package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.User;
import com.commerce.model.UserRole;

public interface UserRoleJpaRepository extends JpaRepository<UserRole,Long>{
}
