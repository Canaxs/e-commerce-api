package com.commerce.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity{
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	User user;
	
	@ManyToOne
	Product product;
}
