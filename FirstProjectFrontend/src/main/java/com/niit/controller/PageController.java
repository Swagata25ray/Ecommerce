package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
	@RequestMapping(value="/")
	public String MyRootPage()
	{
		return "index";
	}
	
	@RequestMapping(value="/home")
	public String RootPage()
	{
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String ShowLoginPage()
	{
		return "Login";
	}
	
	@RequestMapping(value="/register")
	public String ShowRegisterPage()
	{
		return "Register";
	}
	
	@RequestMapping(value="/contactus")
	public String ShowContactUsPage()
	{
		return "ContactUs";
	}
	
	@RequestMapping(value="/aboutus")
	public String ShowAboutUsPage()
	{
		return "AboutUs";
	}
	
}
