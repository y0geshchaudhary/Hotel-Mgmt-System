package com.HMS.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HMS.domain.RoleDTO;

@Repository
public class RoleDAO 
{

	private Logger logger = Logger.getLogger(RoleDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addEntity(RoleDTO roleDto){
		logger.debug("inside addEntity(RoleDTO roleDto) method.");
		boolean successFlag = false;
		try{
			sessionFactory.getCurrentSession().save(roleDto);
			successFlag = true;
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return successFlag;
	}
	
	
	public List<RoleDTO> getAllRoles(){
		logger.debug("inside getAllRoles() method.");
		List<RoleDTO> list = null;
		try{
			list = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return list;
	}

	
	
	public boolean Update(RoleDTO roleDTO) {
		logger.debug("inside Update(RoleDTO roleDTO) method.");
		boolean updateFlag = false;
		try{
		sessionFactory.getCurrentSession().update(roleDTO);
		updateFlag = true;
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return updateFlag;
	}


	public boolean Delete(RoleDTO role){
		logger.debug("inside Delete(RoleDTO role) method.");
		boolean deleteFlag = false;
		try{
			sessionFactory.getCurrentSession().delete(role);
			deleteFlag=true;
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return deleteFlag;
	}
	
}
