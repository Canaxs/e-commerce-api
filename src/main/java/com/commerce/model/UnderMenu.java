package com.commerce.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.commerce.annotation.UniqueUsername;

import lombok.Data;

@Data
@Entity
public class UnderMenu extends BaseEntity{

	@NotNull
	@Size(min=2,max=255)
	@UniqueUsername
	private String underMenuName;
	
	@ManyToOne
	Menu menu;
}
