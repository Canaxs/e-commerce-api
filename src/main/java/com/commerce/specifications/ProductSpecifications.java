package com.commerce.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.commerce.model.panel.Product;
import com.commerce.model.panel.UnderMenu;

public class ProductSpecifications {
	
	public static Specification<Product> findAllByUnderMenu(UnderMenu underMenu) {
	    return ((root,cq,cb) -> {
	    	return cb.equal(root.get("underMenu"),underMenu);
	    });
	  }

}
