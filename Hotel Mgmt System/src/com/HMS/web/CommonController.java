package com.HMS.web;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.HMS.domain.GuestDTO;
import com.HMS.service.CommonService;

@Controller
public class CommonController 
{
	
	private Logger logger = Logger.getLogger(CommonController.class);
	
	@Autowired
	CommonService commonService;
	
	
	
	@RequestMapping("/GuestSubMenu")
	public ModelAndView getGuestSubMenu()
	{
		logger.debug("inside getGuestSubMenu() method.");
		ModelAndView model= new ModelAndView("Guest/guestSubMenu");
		
		return model;
	}
	
	@RequestMapping(value="/RoomSubMenu")
	public ModelAndView getRoomSubMenu()
	{
		logger.debug("inside getRoomSubMenu() method.");
		ModelAndView model = new ModelAndView("Room/roomSubMenu");
		
		return model;
	}
	
	@RequestMapping(value="/addGuest", method=RequestMethod.GET)
	public ModelAndView addGuestScreen()
	{
		logger.debug("inside addGuestScreen() method. Serving GET method");
		ModelAndView model= new ModelAndView("Guest/addNewGuest");
		GuestDTO guestDto= new GuestDTO();
		model.addObject("guestDto", guestDto);
		
		return model;
		
	}
	
	@RequestMapping(value="/addGuest", method=RequestMethod.POST)
	public ModelAndView addGuest(@Valid @ModelAttribute("guestDTO") GuestDTO guestDTO, BindingResult result)
	{
		logger.debug("inside addGuestScreen() method. Serving POST method");
		
		ModelAndView model = new ModelAndView();
		
		if(result.hasErrors())
		{
			int errorCount = result.getErrorCount();
			model.addObject("errorCount", errorCount);
			model.setViewName("Guest/addNewGuest");
			logger.debug("guestDTO have errors so setting view as "+model.getViewName());
		}
		
		else
		{
			logger.debug("guestDTO donot have errors.");
			commonService.addGuest(guestDTO);
			model.setViewName("success");
			logger.debug("Setting view as "+model.getViewName());
		}
		
		return model;
	}

}
