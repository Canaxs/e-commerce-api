package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.Cart;

public interface CartJpaRepository extends JpaRepository<Cart, Long>{

}
