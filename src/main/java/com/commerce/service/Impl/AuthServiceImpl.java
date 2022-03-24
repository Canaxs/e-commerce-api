package com.commerce.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.commerce.exception.AuthException;
import com.commerce.model.Token;
import com.commerce.model.User;
import com.commerce.model.UserRole;
import com.commerce.repository.TokenRepository;
import com.commerce.repository.UserJpaRepository;
import com.commerce.request.Credentials;
import com.commerce.request.UserAuthRes;
import com.commerce.request.UserVM;
import com.commerce.service.AuthService;
import com.commerce.utils.Enums;
import com.commerce.utils.Enums.RoleType;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthServiceImpl implements AuthService{
	
	UserJpaRepository userJpaRepository;
	
	TokenRepository tokenRepository;

	public AuthServiceImpl(UserJpaRepository userJpaRepository, TokenRepository tokenRepository) {
		super();
		this.userJpaRepository = userJpaRepository;
		this.tokenRepository = tokenRepository;
	}

	@Override
	public UserAuthRes authenticate(Credentials credentials) {
		User inDB = userJpaRepository.findByUsername(credentials.getUsername());
		if(inDB == null) {
			throw new AuthException();
		}
		if(!credentials.getPassword().equals(inDB.getPassword())) {
			throw new AuthException();
		}
		UserVM userVM = new UserVM(inDB);
		String token = Jwts.builder().setSubject(""+inDB.getId()).signWith(SignatureAlgorithm.HS512, "twitter").compact();
		
		Token tokenEntity = new Token();
		tokenEntity.setToken(token);
		tokenEntity.setUser(inDB);
		tokenRepository.save(tokenEntity);
		
		UserAuthRes response = new UserAuthRes();
		response.setUser(userVM);
		response.setToken("Bearer "+token);
		return response;
	}

	@Override
	@Transactional
	public UserDetails getUserDetails(String token) {
		System.out.println("Token: "+ token);
		JwtParser parser = Jwts.parser().setSigningKey("twitter");
		try {			
			parser.parse(token);
			Claims claims = parser.parseClaimsJws(token).getBody();
			long userId = new Long(claims.getSubject());
			User user = userJpaRepository.getOne(userId);
			User actualUser = (User)((HibernateProxy)user).getHibernateLazyInitializer().getImplementation();
			return actualUser;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void clearToken(String token) {
		tokenRepository.deleteById(token);	
	}

}
