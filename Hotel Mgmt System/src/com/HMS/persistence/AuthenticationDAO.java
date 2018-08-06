package com.HMS.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationDAO
{
	private Logger logger = Logger.getLogger(AuthenticationDAO.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<?> getAllDtoListAtStartUp(Class<?> classs)
	{
		logger.debug("inside getAllDtoListAtStartUp(Class<?> classs) method.");
		
		List<?> dtoList = new ArrayList();
		Transaction trans = null;
		Session session = null;
		
		try
		{
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			
			dtoList = session.createCriteria(classs).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			trans.commit();
		}
		catch(Exception e)
		{
			logger.debug("Exception occured");
			if(session.isOpen())
			{
				logger.debug("Transaction is Rolling Back.");
			}
			logger.error(e.getMessage());
		}
		finally
		{
			if(session.isOpen())
			{
				session.close();
			}
		}
		
		logger.debug("dtoList size is : "+dtoList.size());
		return dtoList;
	}
	
}
