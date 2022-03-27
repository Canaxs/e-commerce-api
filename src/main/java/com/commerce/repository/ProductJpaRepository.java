package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.commerce.model.panel.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long>,JpaSpecificationExecutor<Product>{
}
