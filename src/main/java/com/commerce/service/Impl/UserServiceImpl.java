package com.commerce.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.commerce.dto.Credentials;
import com.commerce.dto.RoleRequest;
import com.commerce.model.User;
import com.commerce.model.UserRole;
import com.commerce.repository.UserJpaRepository;
import com.commerce.repository.UserRoleJpaRepository;
import com.commerce.service.UserService;
import com.commerce.utils.Enums;

@Service
public class UserServiceImpl implements UserService{
	
	UserJpaRepository userJpaRepository;
	
	UserRoleJpaRepository userRoleJpaRepository;

	public UserServiceImpl(UserJpaRepository userJpaRepository,UserRoleJpaRepository roleJpaRepository) {
		super();
		this.userJpaRepository = userJpaRepository;
		this.userRoleJpaRepository = roleJpaRepository;
	}

	@Override
	public User create(Credentials credentials) {
		User user = new User();
		List<UserRole> userRole = new ArrayList<UserRole>();
		UserRole userRole2 = new UserRole();
		
		user.setPassword(credentials.getPassword());
		user.setUsername(credentials.getUsername());
		userJpaRepository.save(user);
		
		User user2 = userJpaRepository.findByUsername(credentials.getUsername());
		userRole2.setUser(user2);
		userRole2.setRoleType(Enums.RoleType.USER);
		userRole.add(userRole2);
		user.setUserRoles(userRole);
		userJpaRepository.save(user);
		
		return null;
	}

	@Override
	public User roleChange(String username, RoleRequest roleRequest) {
		User user = userJpaRepository.findByUsername(username);
		UserRole userRole2 = userRoleJpaRepository.findByUserId(user.getId());
		userRole2.setUser(user);
		switch (roleRequest.getRole().toUpperCase()) {
		case "ADMIN":
			userRole2.setRoleType(Enums.RoleType.ADMIN);
			break;
		case "USER":
			userRole2.setRoleType(Enums.RoleType.USER);
			break;
		case "MOD":
			userRole2.setRoleType(Enums.RoleType.MOD);
			break;
		default:
			break;
		}
		System.out.println("Role: "+userRole2.getRoleType());
		userRoleJpaRepository.save(userRole2);
		return user;
	}

	
}
