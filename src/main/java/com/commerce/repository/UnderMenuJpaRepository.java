package com.commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.model.Menu;
import com.commerce.model.UnderMenu;

public interface UnderMenuJpaRepository extends JpaRepository<UnderMenu, Long>{
	
	UnderMenu findByUnderMenuNameAndMenu(String underMenuName,Menu menu);

	List<UnderMenu> findAllByMenu(Menu menu);
	
	UnderMenu findByid(long id);
}
