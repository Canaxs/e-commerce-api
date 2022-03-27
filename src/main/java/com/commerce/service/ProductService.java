package com.commerce.service;

import java.util.List;

import com.commerce.dto.ProductDto;
import com.commerce.model.panel.Product;

public interface ProductService {

	Product updateProduct(long productId, ProductDto productDto);

	Product deleteProduct(long productId);

	Product createProduct(ProductDto productDto);

	List<Product> getListProduct(long underMenuId);

}
