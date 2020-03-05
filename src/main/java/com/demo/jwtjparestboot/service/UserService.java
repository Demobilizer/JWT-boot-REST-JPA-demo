package com.demo.jwtjparestboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.jwtjparestboot.dao.UserDao;
import com.demo.jwtjparestboot.model.UserModel;

@Service("jwtUserService")
public class UserService {
	
	@Autowired
	@Qualifier("jwtUerDao")
	UserDao userDao;

	public void saveUser(UserModel userModel) {
		userDao.save(userModel);
	}

}
