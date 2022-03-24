package com.commerce.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.commerce.request.Credentials;
import com.commerce.request.UserAuthRes;

public interface AuthService {
	
	UserAuthRes authenticate(Credentials credentials);
	UserDetails getUserDetails(String token);
	void clearToken(String token);
}
