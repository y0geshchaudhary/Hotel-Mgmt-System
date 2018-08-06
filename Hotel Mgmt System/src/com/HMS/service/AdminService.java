package com.HMS.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.domain.RoleDTO;
import com.HMS.persistence.RoleDAO;
import com.HMS.util.BootUpLodder;

@Service
@Transactional
public class AdminService 
{
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private BootUpLodder bootUpLodder;
	
	
	private Logger logger = Logger.getLogger(AdminService.class);
	
	public boolean AddRole(RoleDTO roleDTO)
	{
		logger.debug("inside addRole(RoleDTO roleDTO) method.");
		boolean roleAdded = false;
		try{
			roleAdded = roleDAO.addEntity(roleDTO);;
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return roleAdded;
	}
	
	public boolean UpdateRole(RoleDTO roleDTO){
		logger.debug("inside UpdateRole(RoleDTO roleDTO)");
		return roleDAO.Update(roleDTO);
	}

	public boolean DeleteRole(RoleDTO role){
		return roleDAO.Delete(role);
	}
}
