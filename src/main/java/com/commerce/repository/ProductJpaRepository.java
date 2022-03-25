package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long>{

}
