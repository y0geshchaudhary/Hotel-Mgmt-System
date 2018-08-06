package com.HMS.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.domain.GuestDTO;
import com.HMS.persistence.GuestDAO;

@Service
@Transactional
public class CommonService 
{
	
	private Logger logger = Logger.getLogger(CommonService.class);
	
	@Autowired
	GuestDAO guestDAO;
	
	
	public boolean addGuest(GuestDTO guestDTO)
	{
		return guestDAO.addGuest(guestDTO);
		
	}
}
