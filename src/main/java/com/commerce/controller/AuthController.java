package com.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.model.User;
import com.commerce.request.Credentials;
import com.commerce.request.UserAuthRes;
import com.commerce.service.AuthService;

@RestController
@RequestMapping("/api/1.0/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping
	private UserAuthRes isLogged(@RequestBody Credentials credentials) {
		return authService.authenticate(credentials);
	}
	
	@PostMapping("/logout")
	String handleLogout(@RequestHeader(name = "Authorization") String authorization) {
		String token = authorization.substring(7);
		authService.clearToken(token);
		return "Logout success";
	}
}
