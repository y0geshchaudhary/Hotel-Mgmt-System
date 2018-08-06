package com.HMS.util;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.domain.EmployeeDTO;
import com.HMS.domain.RoleDTO;
import com.HMS.domain.RoomDTO;
import com.HMS.persistence.AuthenticationDAO;
import com.HMS.service.AdminService;

@Service
@Transactional
public class BootUpLodder 
{

	@Autowired
	AuthenticationDAO authenticationDAO;
	
	private Logger logger = Logger.getLogger(BootUpLodder.class);

	@PostConstruct
	public void Bootup()
	{
		LoadAllRoleOnStartUp();
		LoadAllEmployeeOnStartUp();
		LoadAllRoomOnStartUp();
	}
	
	private void LoadAllRoomOnStartUp() {
		logger.debug("Inside LoadAllRoomOnStartUp() method.");
		ApplicationMaps.ROOMID_ROOM_MAP.clear();
		List<RoomDTO> list =(List<RoomDTO>) authenticationDAO.getAllDtoListAtStartUp(RoomDTO.class);
		if(list!=null || list.size()>0)
		{
			for(RoomDTO dto : list)
			{
				ApplicationMaps.ROOMID_ROOM_MAP.put(dto.getRoomId(), dto);
			}
		}
		logger.debug("Loaded ApplicationMaps.ROOMID_ROOM_MAP and its size is :"+ApplicationMaps.ROOMID_ROOM_MAP.size());
	}

	private void LoadAllEmployeeOnStartUp() {
		logger.debug("Inside LoadAllEmployeeOnStartUp() method.");
		ApplicationMaps.EMPLOYEEID_EMPLOYEE_MAP.clear();
		List<EmployeeDTO> list =(List<EmployeeDTO>) authenticationDAO.getAllDtoListAtStartUp(EmployeeDTO.class);
		if(list!=null || list.size()>0)
		{
			for(EmployeeDTO dto : list)
			{
				ApplicationMaps.EMPLOYEEID_EMPLOYEE_MAP.put(dto.getEmployeeId(),dto);
			}
		}
		logger.debug("Loaded ApplicationMaps.EMPLOYEEID_EMPLOYEE_MAP and its size is :"+ApplicationMaps.EMPLOYEEID_EMPLOYEE_MAP.size());
	}

	public void LoadAllRoleOnStartUp()
	{
		logger.debug("Inside loadAllRoleOnStartUp() method.");
		ApplicationMaps.ROLEID_ROLE_MAP.clear();
		List<RoleDTO> list = (List<RoleDTO>) authenticationDAO.getAllDtoListAtStartUp(RoleDTO.class);
		if(list != null || list.size()>0)
		{
			for(RoleDTO roleDTO : list)
			{
				ApplicationMaps.ROLEID_ROLE_MAP.put(roleDTO.getRoleId(), roleDTO);
			}
		}
		
		logger.debug("Loaded ApplicationMaps.ROLEID_ROLE_MAP and its size is :"+ApplicationMaps.ROLEID_ROLE_MAP.size());
	}
	
}
