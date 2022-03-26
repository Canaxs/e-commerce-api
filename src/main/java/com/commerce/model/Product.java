package com.commerce.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.commerce.annotation.UniqueUsername;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Product extends BaseEntity{
	
	@NotNull
	@Size(min=2,max=255)
	@UniqueUsername
	private String Name;
	
	@NotNull
	private int Price;
	
	@Size(min=2,max=255)
	private String Description;
	
	private String Image;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@NotNull
	UnderMenu underMenu;
}
