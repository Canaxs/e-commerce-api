package com.commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.Orders;
import com.commerce.model.User;

public interface OrderJpaRepository extends JpaRepository<Orders, Long>{
	
	List<Orders> findAllByUser(User user);

}
