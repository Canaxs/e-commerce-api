package com.commerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;

import com.commerce.utils.Enums.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class UserRole extends BaseEntity implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "role_type")
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@JoinColumn(name = "user_id")
	@ManyToOne
	@JsonIgnore
	private User user;
	
	
	@Override
	public String getAuthority() {
		return roleType.name();
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}


	public void setUser(User user) {
		this.user = user;
	}
	

}
