package com.cy.ssm.service;

import com.cy.ssm.pojo.User;

public interface UserService {
	//用户登录
	public User userLogin(User user);
	//用户注册
	public void userRegister(User user);
	//查询要修改的个人信息
	public User findById(String id);
	//修改查询到的个人信息
	public void updatemes(User user);
	/**
	 * 发送验证码
	 * @param telephone
	 * @return code
	 * @throws Exception 
	 */
	public String createSmsCode(String telephone) throws Exception;
}
