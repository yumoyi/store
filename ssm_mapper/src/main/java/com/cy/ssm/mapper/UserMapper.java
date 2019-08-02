package com.cy.ssm.mapper;

import com.cy.ssm.pojo.User;


public interface UserMapper {
    //用户登录
	public User userLogin(User user);
	//用户注册
	public void userRegister(User user);
	//查询要修改的个人信息
	public User findById(String id);
	//修改查询到的个人信息
	public void updatemes(User user);
}
