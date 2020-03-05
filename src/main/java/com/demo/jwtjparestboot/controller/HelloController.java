package com.demo.jwtjparestboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jwtjparestboot.config.JwtTokenUtil;
import com.demo.jwtjparestboot.model.UserModel;
import com.demo.jwtjparestboot.service.UserService;

@RestController
public class HelloController {
	
	@Autowired
	@Qualifier("jwtUserService")
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil JwtTokenUtil;

	@GetMapping("/hello")
	public String HelloMethod(HttpServletRequest request) {
		
		String username = null;
		String jwtToken = null;
		final String requestTokenHeader = request.getHeader("Authorization");
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			username = JwtTokenUtil.getUsernameFromToken(jwtToken);
		}
		
		return "Hello "+ username + "! Authentication successfull :)";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserModel userModel) {
		userService.saveUser(userModel);
		return "user registration done successfully!";
	}
}
