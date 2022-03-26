package com.commerce.dto;

import lombok.Data;

@Data
public class ProductDto {

	private String Name;
	private int Price;
	private String Description;
	private String Image;
	private long underMenuId;
}
