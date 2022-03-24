package com.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.model.User;
import com.commerce.request.Credentials;
import com.commerce.request.RoleRequest;
import com.commerce.service.UserService;


@RestController
@RequestMapping("/api/1.0/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/create")
	private User createUser(@RequestBody Credentials credentials) {
		return service.create(credentials);
	}
	
	@PostMapping("/{username}")
	private User userRoleChange(@PathVariable String username,@RequestBody RoleRequest roleRequest) {
		return service.roleChange(username,roleRequest);
	}


}
