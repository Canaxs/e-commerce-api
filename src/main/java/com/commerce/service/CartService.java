package com.commerce.service;

import java.util.List;

import com.commerce.dto.ProductDto;
import com.commerce.model.Cart;
import com.commerce.model.User;

public interface CartService {
	
	User Auth();

	Cart add(long productId);

	Cart delete(long cartId);

	List<Cart> getCartList();
	
	List<Cart> getAllBuy();

}
