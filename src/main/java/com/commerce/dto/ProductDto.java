package com.commerce.dto;

import lombok.Data;

@Data
public class ProductDto {

	String Name;
	int Price;
	String Description;
	String Image;
	long underMenuId;
}
