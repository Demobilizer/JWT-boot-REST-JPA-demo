package com.demo.jwtjparestboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.jwtjparestboot.dao.UserDao;
import com.demo.jwtjparestboot.model.UserModel;

@Service
public class JwtUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel userModel = userDao.findByUsername(username);
		if(userModel == null) {
			throw new UsernameNotFoundException("user not found with username: "+username);
		}
		return new User(userModel.getUsername(), passwordEncoder.encode(userModel.getPassword()), new ArrayList<>());
	}
	
}
