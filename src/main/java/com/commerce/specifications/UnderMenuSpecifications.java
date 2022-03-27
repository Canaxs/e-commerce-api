package com.commerce.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.commerce.model.panel.Menu;
import com.commerce.model.panel.UnderMenu;

public class UnderMenuSpecifications {
	
	public static Specification<UnderMenu> findAllByMenu(Menu menu) {
	    return ((root,cq,cb) -> {
	    	return cb.equal(root.get("menu"),menu);
	    });
	  }

}
