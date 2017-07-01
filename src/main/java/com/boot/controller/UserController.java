package com.boot.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.model.User;

import com.boot.service.UserService;

@Controller
@RequestMapping(value="User")
public class UserController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	@Autowired
	public UserService userservice;
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register()
	{
	System.out.println("controller called");
		return "registeruser";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser( @RequestParam("name") String name,
			@RequestParam("uname") String username , @RequestParam("psw") String password ,
			@RequestParam("mobno") long mobileno ,@RequestParam("mailid") String emailid){
		System.out.println("inside the controller");
		User user = new User(name,username,emailid,mobileno,password,true); 
		
		userservice.save(user);
		return "loginuser";
	
	}
	
	@ResponseBody
	@GetMapping
	public String home(){
		return "Controller Called";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login()
	{
		System.out.println("login controller");
		return "loginuser";
		
	}

	@RequestMapping(value="/loginaccount", method=RequestMethod.POST)
	public String loginUser(@RequestParam("username") String userName,
			@RequestParam("password") String password, ModelMap modelMap, HttpSession session)
	{
	System.out.println("controller logged in");	
	LOGGER.info("Entering Login " + userName + "-" + password);
	LOGGER.debug(new Object[] { userName, password });

	
	User user = userservice.login(userName,password);
	LOGGER.info("User:" + userName);
	if (user != null) {
		session.setAttribute("LOGGED_IN_USER", user);
		LOGGER.info("Login Success");
		return "redirect:../Book";
	
	
	}
	 else {
			modelMap.addAttribute("USERNAME" , userName );
			modelMap.addAttribute("ERROR_MESSAGE", "Invalid username/Password");
			LOGGER.error("Login Failure");
			return "user/login";
		}
	
}
	
}