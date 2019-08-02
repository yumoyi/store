package com.cy.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.cy.ssm.mapper.UserMapper;
import com.cy.ssm.pojo.User;
import com.cy.ssm.service.UserService;
import com.cy.ssm.utils.SendUtils;

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

	@Override
	public String createSmsCode(String telephone) throws ClientException {
		//生成4位随机数
		String code1 = (int)(Math.random()*10)+"";
		String code2 = (int)(Math.random()*10)+"";
		String code3 = (int)(Math.random()*10)+"";
		String code4 = (int)(Math.random()*10)+"";
		String code = code1+code2+code3+code4;
		System.out.println("验证码:"+code);
		//SendUtils.sendSms(telephone, code);
		return code;
	}
}