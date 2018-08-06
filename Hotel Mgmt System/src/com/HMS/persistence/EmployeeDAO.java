package com.HMS.persistence;

import java.util.List;

import org.apache.log4j.Logger;

import com.HMS.domain.EmployeeDTO;

public class EmployeeDAO 
{
	private Logger logger = Logger.getLogger(EmployeeDAO.class);
	
	public void addEmployee(EmployeeDTO employeeDTO)
	{}
	
	public void updateEmployee(EmployeeDTO employeeDTO)
	{}
	
	public void deleteEmployee(int employeeID)
	{}
	
	/*
	 * Search for all employee when search bar returns null else search for 
	 * only mentioned employee Id
	 * */
	public List<EmployeeDTO> searchEmployee(String search)
	{return null;}
	
	
	
}
