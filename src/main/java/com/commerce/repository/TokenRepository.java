package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.Token;


public interface TokenRepository extends JpaRepository<Token, String>{

}
