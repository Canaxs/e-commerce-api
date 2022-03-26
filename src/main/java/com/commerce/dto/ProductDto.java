package com.commerce.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.commerce.model.Product;
import com.commerce.repository.UnderMenuJpaRepository;

import lombok.Data;

@Data
public class ProductDto {

	String Name;
	int Price;
	String Description;
	String Image;
	long underMenuId;
	
	public Product getProduct() {
		Product product = Product.builder()
				.Name(Name)
				.Price(Price)
				.Description(Description)
				.Image(Image)
				.build();
		return product;
	}

	public ProductDto(String name, int price, String description,
			String image, long underMenuId) {
		super();
		Name = name;
		Price = price;
		Description = description;
		Image = image;
		this.underMenuId = underMenuId;
	}
}
