package com.commerce.model.panel;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.commerce.annotation.UniqueUsername;
import com.commerce.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Menu extends BaseEntity{

	@NotNull
	@Size(min=2,max=255)
	@UniqueUsername
	private String menuName;
	
}
