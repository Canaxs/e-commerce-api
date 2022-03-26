package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.Orders;

public interface OrderJpaRepository extends JpaRepository<Orders, Long>{

}
