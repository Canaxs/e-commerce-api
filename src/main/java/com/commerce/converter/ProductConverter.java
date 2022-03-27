package com.commerce.converter;

import org.springframework.stereotype.Component;

import com.commerce.dto.ProductDto;
import com.commerce.model.panel.Product;

@Component
public class ProductConverter {


	public Product getProduct(ProductDto productDto) {
		Product product = Product.builder()
				.Name(productDto.getName())
				.Price(productDto.getPrice())
				.Description(productDto.getDescription())
				.Image(productDto.getImage())
				.build();
		return product;
	}
}
