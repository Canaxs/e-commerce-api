package com.commerce.service.Impl;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.commerce.converter.ProductConverter;
import com.commerce.dto.ProductDto;
import com.commerce.model.Cart;
import com.commerce.model.Orders;
import com.commerce.model.User;
import com.commerce.model.panel.Product;
import com.commerce.repository.CartJpaRepository;
import com.commerce.repository.OrderJpaRepository;
import com.commerce.repository.ProductJpaRepository;
import com.commerce.repository.UserJpaRepository;
import com.commerce.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	CartJpaRepository cartJpaRepository;
	ProductJpaRepository productJpaRepository;
	UserJpaRepository userJpaRepository;
	ProductConverter productConverter;
	OrderJpaRepository orderJpaRepository;

	public CartServiceImpl(CartJpaRepository cartJpaRepository, ProductJpaRepository productJpaRepository,
			UserJpaRepository userJpaRepository,ProductConverter productConverter,OrderJpaRepository orderJpaRepository) {
		super();
		this.orderJpaRepository = orderJpaRepository;
		this.cartJpaRepository = cartJpaRepository;
		this.productConverter = productConverter;
		this.productJpaRepository = productJpaRepository;
		this.userJpaRepository = userJpaRepository;
	}
	
	@Override
	public User Auth() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return userJpaRepository.findByUsername(name);
	}

	@Override
	public Cart add(long productId) {
		Product product = productJpaRepository.getById(productId);
		Cart cart = new Cart();
		try {
			cart.setProduct(product);
			cart.setUser(Auth());
		}
		catch(Error e) {	
		}
		return cartJpaRepository.save(cart);
	}

	@Override
	public Cart delete(long cartId) {
		Cart cart = cartJpaRepository.getById(cartId);
		try {
			cartJpaRepository.delete(cart);
			}
		catch(Error e) {	
		}
		return cart;
	}

	@Override
	public List<Cart> getCartList() {
		User user = Auth();
		List<Cart> cart = cartJpaRepository.findAllByUser(user);
		return cart;
	}

	@Override
	public List<Cart> getAllBuy() {
		User user = Auth();
		List<Cart> carts = cartJpaRepository.findAllByUser(user);
		for(Cart cart : carts) {
			Orders order = new Orders();
			order.setProduct(cart.getProduct());
			order.setUser(user);
			orderJpaRepository.save(order);
			cartJpaRepository.delete(cart);
		}
		return carts;
	}

}
