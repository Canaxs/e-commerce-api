package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.commerce.model.panel.Menu;

public interface MenuJpaRepository extends JpaRepository<Menu, Long>,JpaSpecificationExecutor<Menu>{
	
	Menu findBymenuName(String menuName);

}
