package com.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.dto.ProductDto;
import com.commerce.model.Product;
import com.commerce.service.ProductService;

@RestController
@RequestMapping("/api/1.0/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	private Product createProduct(@RequestBody ProductDto productDto) {
		return productService.createProduct(productDto);
	}
	
	@DeleteMapping("/{productId}")
	private Product deleteProduct(@PathVariable long productId) {
		return productService.deleteProduct(productId);
	}
	
	@PutMapping("/{productId}")
	private Product updateProduct(@PathVariable long productId,@RequestBody ProductDto productDto) {
		return productService.updateProduct(productId,productDto);
	}
	@GetMapping("/{underMenuId}")
	private List<Product> getListProduct(@PathVariable long underMenuId) {
		return productService.getListProduct(underMenuId);
	}
	
}
