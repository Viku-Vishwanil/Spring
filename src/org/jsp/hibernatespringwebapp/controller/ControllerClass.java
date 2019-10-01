package org.jsp.hibernatespringwebapp.controller;

import org.jsp.hibernatespringwebapp.dto.UserDTO;
import org.jsp.hibernatespringwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ControllerClass 
{
	@Autowired
	UserService service;
	
	@RequestMapping("/")
	public String getHomePage()
	{
		return "homepage";
	}
	
	@RequestMapping("/register")
	public String getRegisterPage(Model myModel)
	{
		UserDTO dto = new UserDTO();
		
		System.out.println(dto);
				
		myModel.addAttribute("employee", dto);
		
		return "register";
	}
	
	@RequestMapping("/saveemployee")
	public String saveUser(@ModelAttribute("employee") UserDTO dto)
	{
		System.out.println(dto);
		
		service.saveUser(dto);
		
		return "redirect:/";
	}
	
	@RequestMapping("/authenticate")
	public String authenticateUser(@RequestParam("username")String username,@RequestParam("password")String password,Model myModel)
	{
		if(service.authenticateUser(username,password))
		{
			UserDTO dto = service.getUser(username,password);
			
			myModel.addAttribute("userinfo", dto);
			myModel.addAttribute("username", dto.getUsername());
			
			return "redirect:/profile";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/profile")
	public String getProfile()
	{
		return "profile";
	}
}