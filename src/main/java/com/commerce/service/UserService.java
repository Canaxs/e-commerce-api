package com.commerce.service;

import com.commerce.dto.Credentials;
import com.commerce.dto.RoleRequest;
import com.commerce.model.User;

public interface UserService {
	
	User create(Credentials credentials);

	User roleChange(String username, RoleRequest roleRequest);

}
