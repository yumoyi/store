package com.cy.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.ssm.mapper.UserMapper;
import com.cy.ssm.pojo.User;
import com.cy.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User userLogin(User user) {
		User uu=userMapper.userLogin(user);
		if(null==uu){
			throw new RuntimeException("密码有误!");
		}else{
			return uu;
		}
	}

	@Override
	public void userRegister(User user) {
		userMapper.userRegister(user);		
	}

	@Override
	public User findById(String id) {
		 return userMapper.findById(id);		
	}

	@Override
	public void updatemes(User user) {
		userMapper.updatemes(user);	
		
	}

	

}