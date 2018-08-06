package com.HMS.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="roles")
public class RoleDTO
{	

	@NotEmpty(message="Please provide Role Id.")
	private String roleId;
	
	@NotEmpty(message="Please provide Role Description.")
	private String roleDesc;

	@Id
	@Column(name="roleId",length=10,nullable=false,unique=true)
	public String getRoleId() {
		return roleId;
	}
	
	@Column(name="roleDescription")
	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "RoleDTO [roleId=" + roleId + ", roleDesc=" + roleDesc + "]";
	}
	
	
	
}
