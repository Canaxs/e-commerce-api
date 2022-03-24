package com.commerce.service;

import com.commerce.model.User;
import com.commerce.request.Credentials;
import com.commerce.request.RoleRequest;

public interface UserService {
	
	User create(Credentials credentials);

	User roleChange(String username, RoleRequest roleRequest);

}
