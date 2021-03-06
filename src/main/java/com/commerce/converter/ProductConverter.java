package com.commerce.converter;

import org.springframework.stereotype.Component;

import com.commerce.dto.ProductDto;
import com.commerce.model.panel.Product;
import com.commerce.repository.UnderMenuJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductConverter {
	
	final UnderMenuJpaRepository underMenuJpaRepository;


	public Product getProduct(ProductDto productDto) {
		Product product = Product.builder()
				.Name(productDto.getName())
				.Price(productDto.getPrice())
				.Description(productDto.getDescription())
				.Image(productDto.getImage())
				.underMenu(underMenuJpaRepository.getById(productDto.getUnderMenuId()))
				.build();
		return product;
	}
}
