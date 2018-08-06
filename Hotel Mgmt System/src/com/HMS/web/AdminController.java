package com.HMS.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.HMS.domain.EmployeeDTO;
import com.HMS.domain.RoleDTO;
import com.HMS.domain.TestDTO;
import com.HMS.service.AdminService;
import com.HMS.util.ApplicationMaps;
import com.HMS.util.BootUpLodder;

@Controller
public class AdminController 
{
	
	private Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	BootUpLodder bootUpLodder;
	
	@RequestMapping("/Welcome")
	public ModelAndView welcome()
	{
		logger.debug("inside welcome() method.");
		ModelAndView model= new ModelAndView("welcome");
		return model;
	}
	
	
	@RequestMapping(value="/AdminTaskSubMenu")
	public ModelAndView getAdminTaskSubMenu()
	{
		logger.debug("getAdminTaskSubMenu() method.");
		ModelAndView model = new ModelAndView("AdminTask/adminTaskSubMenu");
		return model;
	}
	
	@RequestMapping(value="/addRole", method=RequestMethod.GET)
	public ModelAndView addRoleScreen()
	{
		logger.debug("inside addRoleScreen() method. Serving GET request.");
		ModelAndView model = new ModelAndView("AdminTask/addRole");
		RoleDTO roleDTO= new RoleDTO();
		model.addObject("roleDTO", roleDTO);
		return model;
	}
	
	@RequestMapping(value="/addRole", method=RequestMethod.POST)
	public ModelAndView addRole(@Valid @ModelAttribute("roleDTO") RoleDTO roleDTO, BindingResult result)
	{
		logger.debug("inside addRole(@Valid @ModelAttribute(roleDTO) RoleDTO roleDTO, BindingResult result) method. Serving POST request.");
		ModelAndView model = new ModelAndView();
		boolean haveError=false;
		FieldError fieldError;
		
		if(ApplicationMaps.ROLEID_ROLE_MAP.containsKey(roleDTO.getRoleId()))
		{
			fieldError = new FieldError("roleDTO", "roleId", "Role Already Exists.");
			result.addError(fieldError);
		}
		
		if(result.hasErrors())
		{
			haveError=true;
			model.addObject("haveError",haveError);
			model.setViewName("AdminTask/addRole");
			logger.debug("roleDto have errors. Setting view name as "+ model.getViewName());
		}
		 
		else
		{
			boolean addResult = adminService.AddRole(roleDTO);
			logger.debug("Reloading ApplicationMaps.ROLEID_ROLE_MAP");
			bootUpLodder.LoadAllRoleOnStartUp();
			logger.debug("ApplicationMaps.ROLEID_ROLE_MAP size is : "+ApplicationMaps.ROLEID_ROLE_MAP.size());
			if(addResult) model.setViewName("success");
			else model.setViewName("exception");
			
			logger.debug("Setting view name as "+model.getViewName());
		}
		
		return model;
	}
	
	@RequestMapping(value="/roleSearchScreen", method=RequestMethod.GET)
	public ModelAndView roleSearchScreen()
	{	
		logger.debug("inside roleSearchScreen()");
		ModelAndView model = new ModelAndView("AdminTask/searchRole");
		RoleDTO roleDTO = new RoleDTO();
		model.addObject(roleDTO);
		
		return  model;
	}
	
	@RequestMapping(value="/searchRoles", method=RequestMethod.GET)
	public ModelAndView roleSearchResult(@ModelAttribute("roleDTO") RoleDTO roleDTO, HttpSession session)
	{
		logger.debug("inside roleSearchResult(@ModelAttribute(roleDTO) RoleDTO roleDTO)");
		ModelAndView model = new ModelAndView("AdminTask/roleSearchResult");
		List list = new ArrayList<RoleDTO>();
		int listSize = 0;
		
		if(roleDTO.getRoleId() == null || roleDTO.getRoleId().trim().length() == 0){
			logger.debug("inside if as roleDTO.getRoleId().trim().length() = "+roleDTO.getRoleId().trim().length());
			list = new ArrayList(ApplicationMaps.ROLEID_ROLE_MAP.values());			
			listSize = list.size();
		}
		
		else if (roleDTO.getRoleId().trim().length()>0){
			logger.debug("inside else if as roleDTO.getRoleId().trim().length()>0");
			
			if(ApplicationMaps.ROLEID_ROLE_MAP.containsKey(roleDTO.getRoleId())){
				list.add(ApplicationMaps.ROLEID_ROLE_MAP.get(roleDTO.getRoleId()));
				listSize = 1;
			}
			
			else{
				list = null;
				listSize = 0;
			}
		}
		
		logger.debug("listSize is ="+listSize+"\n list is = "+list);
		
		session.setAttribute("list",list);
		session.setAttribute("listSize",listSize);
		
		/*model.addObject("list",list);
		model.addObject("listSize",listSize);*/
		
		return model;
	}
	
	@RequestMapping(value="showNextPage", method=RequestMethod.GET)
	public ModelAndView getNextRolePage(){
		logger.debug("inside getNextRolePage() method");
		ModelAndView model = new ModelAndView("AdminTask/roleSearchResult");
		return model;
	}
	
	@RequestMapping(value="updateRoleScreen/{roleId}",method=RequestMethod.GET)
	public ModelAndView UpdateRoleScreen(@PathVariable("roleId") String roleId)
	{
		logger.debug("inside UpdateRoleScreen(@PathVariable(roleId) String roleId) method");
		ModelAndView model = new ModelAndView("AdminTask/updateRoleScreen");
		boolean roleFound= false;
		
		if(ApplicationMaps.ROLEID_ROLE_MAP.containsKey(roleId))
		{
			roleFound = true;
			model.addObject("role", ApplicationMaps.ROLEID_ROLE_MAP.get(roleId));
		}
		logger.debug("view name is: "+model.getViewName());
		return model;
	}
	
	
	@RequestMapping(value="UpdateDeleteRole", method= RequestMethod.POST)
	public ModelAndView UpdateDeleteRole(@Valid @ModelAttribute("role") RoleDTO role,BindingResult result,
			@RequestParam("action") String action){
		
		logger.debug("inside UpdateDeleteRole(@Valid @ModelAttribute('role') RoleDTO role,BindingResult result,"
				+ "@RequestParam('action') String action) method");
		
		ModelAndView model = new ModelAndView();
		boolean hasError= false;
		boolean success= false;
		
		if(result.hasErrors()){
			System.out.println("roleDTO have errors.");			
			hasError = true;
			model.addObject("hasError", hasError);
			model.setViewName("AdminTask/updateRoleScreen");
		}
		if(action.equals("Update")){
			logger.debug("action is Update.");
			success = adminService.UpdateRole(role);
			bootUpLodder.LoadAllRoleOnStartUp();
		}
		
		else if(action.equals("Delete")){
			success = adminService.DeleteRole(role);
			bootUpLodder.LoadAllRoleOnStartUp();
		}
		
		if(success) model.setViewName("success");
		else model.setViewName("exception");
		
		
		return model;
	}
	
	
	@RequestMapping(value="employeeSearchScreen", method=RequestMethod.GET)
	public ModelAndView EmployeeSeachScreen()
	{
		logger.debug("Inside EmployeeSeachScreen() method.");
		ModelAndView model = new ModelAndView("AdminTask/searchEmployee");
		EmployeeDTO employeeDTO = new EmployeeDTO();
		model.addObject("employeeDTO", employeeDTO);
		return model;
	}
	
	@RequestMapping(value="searchEmployee", method=RequestMethod.GET)
	public ModelAndView SearchEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO){
		
		logger.debug("Inside SearchEmployee(@ModelAttribute('employeeDTO') EmployeeDTO employeeDTO)");
		ModelAndView model = new ModelAndView();
		
		
		return null;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView testMethod(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		
		logger.debug("testMethod(HttpRequest request, HttpSession session) method.");
		ModelAndView model = new ModelAndView("test");
		
		List<TestDTO> list = new ArrayList<TestDTO>();
		TestDTO dto;
		
		for(int i=0;i<50;i++){
			
			dto = new TestDTO();
			dto.setName("Name"+i);
			dto.setAge(i);
			dto.setAddress("Address is "+i);
			dto.setPhn(90152125);
			dto.setSports("sports is "+i);
			list.add(dto);
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("This is").append(" a test").append(" Case.");
		
		session.setAttribute("cation", buffer);
		session.setAttribute("list", list);
		logger.debug(list);
		model.addObject("caption", buffer);
		model.addObject("list", list);
		
		
		return model;
	}
	
	@RequestMapping(value="/showNextPage")
	public ModelAndView testShowNextPage(){
		logger.debug("testShowNextPage() method");
		ModelAndView model = new ModelAndView("test");
		return model;
	}
	
}
