package com.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.commerce.model.panel.Menu;
import com.commerce.model.panel.UnderMenu;

public interface UnderMenuJpaRepository extends JpaRepository<UnderMenu, Long>,JpaSpecificationExecutor<UnderMenu>{
	
	UnderMenu findByUnderMenuNameAndMenu(String underMenuName,Menu menu);

}
