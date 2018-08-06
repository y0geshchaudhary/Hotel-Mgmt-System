package com.HMS.persistence;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HMS.domain.GuestDTO;

@Repository
public class GuestDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private Logger logger= Logger.getLogger(GuestDAO.class);
	
	
	public boolean addGuest(GuestDTO guestDTO)
	{
		logger.debug("inside addGuest(GuestDTO guestDTO) method");
		boolean resultofSave= false;
		try
		{
			sessionFactory.getCurrentSession().save(guestDTO);
			resultofSave= true;
		
		}catch(Exception e)
		{
			logger.debug(e.getMessage());
		}
		
		return resultofSave;
	}
	
	/*
	 * For searching all guest check for guestname vaue
	 * if its value is NULL then search for all guest else
	 * search for specific guest with guestName same as varible name.
	 * */
	public List<GuestDTO> searchGuest(String guestName)
	{
		logger.debug("inside searchGuest(String guestName) Method");
		List<GuestDTO> list;
		
		try
		{
			if(guestName == null)
			{
				list = sessionFactory.getCurrentSession().createCriteria(GuestDTO.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				return list;
			}
			else
			{
				list = sessionFactory.getCurrentSession().createCriteria(GuestDTO.class).add(Restrictions.eq("guestName", guestName)).list();
				return list;
			}
		}catch(Exception e)
		{
			logger.debug(e.getMessage());
			return null;
		}
		
	}
	
	public boolean updateGuest(GuestDTO guestDTO)
	{
		logger.debug("inside updateGuest(GuestDTO guestDTO)");
		boolean updateResult= false;
		
		try
		{
			sessionFactory.getCurrentSession().update(guestDTO);
			updateResult=true;
		}
		catch(Exception e)
		{
			logger.debug(e.getMessage()); 
		}
		
		return updateResult;
	}
	
	public boolean deleteGuest(GuestDTO guestDTO)
	{
		logger.debug("inside deleteGuest(GuestDTO guestDTO)");
		boolean deleteResult= false;
		try
		{
			sessionFactory.getCurrentSession().delete(guestDTO);
			deleteResult= true;
		}
		catch(Exception e)
		{
			logger.debug(e.getMessage());
		}
		return deleteResult;
	}
	
	
}
