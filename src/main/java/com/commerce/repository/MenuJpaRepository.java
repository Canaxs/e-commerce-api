package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.Menu;

public interface MenuJpaRepository extends JpaRepository<Menu, Long>{
	
	Menu findBymenuName(String menuName);

}
