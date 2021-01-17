package com.ajay.flightreservation.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajay.flightreservation.entities.User;
import com.ajay.flightreservation.repos.UserRepository;

@Controller
public class UserController {

@Autowired
UserRepository userRepository;

private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}
	
	@RequestMapping(value= "registerUser",method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside register()"+ user);
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap modelMap) {
		//LOGGER.error("ERROR");
		//LOGGER.warn("WARN");
		//LOGGER.info("INFO");
		//LOGGER.debug("DEBUG");
		//LOGGER.trace("TRACE");
		LOGGER.info("Inside login()  email:"+email);
		if(email.equals("")) {
			modelMap.addAttribute("msg", "Invalid username or password. Please try again");
			return "login/login";
		}
		User username = userRepository.findByEmail(email);
		if(username.getPassword().equals(password)) {
			return "findFlights";
		}
		else {
			modelMap.addAttribute("msg", "Invalid username or password. Please try again");
		}
		return "login/login";
	}
}
