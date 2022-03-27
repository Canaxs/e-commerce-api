package com.commerce.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.commerce.model.panel.Menu;

@Component
public class MenuSpecifications {

	public static Specification<Menu> hasMenuName(String menuName) {
	    return ((root,cq,cb) -> {
	    	return cb.like(root.get("menuName"),"%"+menuName+"%");
	    });
	  }
}
