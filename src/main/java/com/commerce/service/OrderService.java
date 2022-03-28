package com.commerce.service;

import java.util.List;

import com.commerce.model.Orders;
import com.commerce.model.User;

public interface OrderService {
	
	User Auth();

	List<Orders> getAllOrders();

	Orders deleteOrder(long orderId);

	Orders getOrder(long orderId);

}
