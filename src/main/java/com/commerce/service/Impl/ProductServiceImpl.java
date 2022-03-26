package com.commerce.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.commerce.dto.ProductDto;
import com.commerce.model.Product;
import com.commerce.model.UnderMenu;
import com.commerce.repository.ProductJpaRepository;
import com.commerce.repository.UnderMenuJpaRepository;
import com.commerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	ProductJpaRepository productJpaRepository;
	UnderMenuJpaRepository underMenuJpaRepository;
	
	ModelMapper modelMapper;

	public ProductServiceImpl(ProductJpaRepository productJpaRepository,
			UnderMenuJpaRepository underMenuJpaRepository,ModelMapper modelMapper) {
		super();
		this.productJpaRepository = productJpaRepository;
		this.underMenuJpaRepository = underMenuJpaRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Product updateProduct(long productId, ProductDto productDto) {
		UnderMenu underMenu = underMenuJpaRepository.findByid(productDto.getUnderMenuId());
		Product product = modelMapper.map(productDto, Product.class);
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
		UnderMenu underMenu = underMenuJpaRepository.findByid(productDto.getUnderMenuId());
		Product product = modelMapper.map(productDto, Product.class);
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
		UnderMenu underMenu = underMenuJpaRepository.findByid(underMenuId);
		List<Product> list = productJpaRepository.findAllByUnderMenu(underMenu);
		return list;
	}

}
