package com.demo.jwtjparestboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.jwtjparestboot.model.UserModel;

@Repository("jwtUerDao")
public interface UserDao extends JpaRepository<UserModel, Integer> {

	public UserModel findByUsername(String username);
	
}
