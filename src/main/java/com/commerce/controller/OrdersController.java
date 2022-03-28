package com.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.model.Orders;
import com.commerce.service.OrderService;

@RestController
@RequestMapping("/api/1.0/orders")
public class OrdersController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping
	private List<Orders> getAllOrders() {
		return orderService.getAllOrders();
	}
	@DeleteMapping("/{orderId}")
	private Orders deleteOrder(@PathVariable long orderId) {
		return orderService.deleteOrder(orderId);
	}
	@GetMapping("/{orderId}")
	private Orders getOrder(@PathVariable long orderId) {
		return orderService.getOrder(orderId);
	}

}
