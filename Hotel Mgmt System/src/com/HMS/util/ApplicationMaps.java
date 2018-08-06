package com.HMS.util;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.HMS.domain.EmployeeDTO;
import com.HMS.domain.RoleDTO;
import com.HMS.domain.RoomDTO;

@Component
public class ApplicationMaps
{

	public static HashMap<String, RoleDTO> ROLEID_ROLE_MAP = new HashMap<String,RoleDTO>();
	public static HashMap<String,EmployeeDTO> EMPLOYEEID_EMPLOYEE_MAP = new HashMap<String,EmployeeDTO>();
	public static HashMap<Integer, RoomDTO> ROOMID_ROOM_MAP = new HashMap<Integer, RoomDTO>();
}
