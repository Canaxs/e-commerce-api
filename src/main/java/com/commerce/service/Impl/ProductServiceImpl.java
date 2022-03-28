package com.commerce.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.commerce.converter.ProductConverter;
import com.commerce.dto.ProductDto;
import com.commerce.model.panel.Product;
import static com.commerce.specifications.ProductSpecifications.*;
import com.commerce.model.panel.UnderMenu;
import com.commerce.repository.ProductJpaRepository;
import com.commerce.repository.UnderMenuJpaRepository;
import com.commerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	ProductJpaRepository productJpaRepository;
	UnderMenuJpaRepository underMenuJpaRepository;
	ProductConverter productConverter;
	

	public ProductServiceImpl(ProductJpaRepository productJpaRepository,
			UnderMenuJpaRepository underMenuJpaRepository,ProductConverter productConverter) {
		super();
		this.productJpaRepository = productJpaRepository;
		this.productConverter = productConverter;
		this.underMenuJpaRepository = underMenuJpaRepository;
	}

	@Override
	public Product updateProduct(long productId, ProductDto productDto) {
		UnderMenu underMenu = underMenuJpaRepository.getById(productDto.getUnderMenuId());
		Product product = productConverter.getProduct(productDto);
		try {
			
			if(underMenu != null && productJpaRepository.existsById(productId)) {
				product.setUnderMenu(underMenu);
				product.setId(productId);
			}
			else {
				return null;
			}
		}
		catch(Error e) {
			
		}
		return productJpaRepository.save(product);
	}

	@Override
	public Product deleteProduct(long productId) {
		Product product = productJpaRepository.getById(productId);
		if(product != null) {
		productJpaRepository.delete(product);
		}
		else {
			return null;
		}
		return product;
	}

	@Override
	public Product createProduct(ProductDto productDto) {
		UnderMenu underMenu = underMenuJpaRepository.getById(productDto.getUnderMenuId());
		Product product = productConverter.getProduct(productDto);
		try {
		
			if(underMenu != null) {
				product.setUnderMenu(underMenu);
			}
			else {
				return null;
			}
		}
		catch(Error e) {
			
		}
		return productJpaRepository.save(product);
	}

	@Override
	public List<Product> getListProduct(long underMenuId) {
		UnderMenu underMenu = underMenuJpaRepository.getById(underMenuId);
		List<Product> list = productJpaRepository.findAll(findAllByUnderMenu(underMenu));
		return list;
	}

}
