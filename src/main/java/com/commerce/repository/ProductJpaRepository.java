package com.commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.Product;
import com.commerce.model.UnderMenu;

public interface ProductJpaRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAllByUnderMenu(UnderMenu underMenu);


}
