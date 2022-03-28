package com.commerce.service.Impl;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import com.commerce.model.Orders;
import com.commerce.model.User;
import com.commerce.repository.OrderJpaRepository;
import com.commerce.repository.UserJpaRepository;
import com.commerce.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	OrderJpaRepository orderJpaRepository;
	UserJpaRepository userJpaRepository;

	public OrderServiceImpl(OrderJpaRepository orderJpaRepository, UserJpaRepository userJpaRepository) {
		super();
		this.orderJpaRepository = orderJpaRepository;
		this.userJpaRepository = userJpaRepository;
	}

	@Override
	public List<Orders> getAllOrders() {
		User user = Auth();
		List<Orders> orders = orderJpaRepository.findAllByUser(user);
		return orders;
	}

	@Override
	public Orders deleteOrder(long orderId) {
		Orders order = orderJpaRepository.getById(orderId);
		try {
			orderJpaRepository.delete(order);
		}
		catch(Error e) {
			
		}
		return order;
	}

	@Override
	public Orders getOrder(long orderId) {
		return orderJpaRepository.getById(orderId);
	}

	@Override
	public User Auth() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userJpaRepository.findByUsername(username);
	}

}
