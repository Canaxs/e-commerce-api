package com.commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.Cart;
import com.commerce.model.User;

public interface CartJpaRepository extends JpaRepository<Cart, Long>{

	List<Cart> findAllByid(long id);
	List<Cart> findAllByUser(User user);
}
