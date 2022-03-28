package com.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.model.Cart;
import com.commerce.service.CartService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/1.0/card")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/add/{productId}")
	public Cart addProductCart(@PathVariable long productId) {
		return cartService.add(productId);
	}
	@DeleteMapping("/{cartId}")
	public Cart deleteProductCart(@PathVariable long cartId) {
		return cartService.delete(cartId);
	}
	@GetMapping
	public List<Cart> getCartList() {
		return cartService.getCartList();
	}
	@GetMapping("/buy")
	public List<Cart> getAllBuy() {
		return cartService.getAllBuy();
	}
	
	

}
