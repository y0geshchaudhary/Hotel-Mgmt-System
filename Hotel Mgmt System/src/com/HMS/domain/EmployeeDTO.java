package com.HMS.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeDTO {

	private String employeeId;
	private String employeeName;
	private String password;
	private int age;
	private Set<RoleDTO> roles = new HashSet<RoleDTO>(0);
	private Set<GuestDTO> guests= new HashSet<GuestDTO>(0);
	
	
	@Id
	@Column(name="EmployeeId",nullable=false,length=10,unique=true)
	public String getEmployeeId() {
		return employeeId;
	}
	@Column(name="EmpName",length=20,nullable=false)
	public String getEmployeeName() {
		return employeeName;
	}
	@Column(name="Password",nullable=false,columnDefinition="varchar(20)")
	public String getPassword() {
		return password;
	}
	@Column(name="Age",length=2)
	public int getAge() {
		return age;
	}
	
	@OneToMany
	@JoinTable(name="Employee_Roles", joinColumns={@JoinColumn(name="EmployeeId")},
	inverseJoinColumns={@JoinColumn(name="roleId")})
	public Set<RoleDTO> getRoles() {
		return roles;
	}
	
	@OneToMany(mappedBy="employee")
	public Set<GuestDTO> getGuests() {
		return guests;
	}
	public void setGuests(Set<GuestDTO> guests) {
		this.guests = guests;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

	
	
}
