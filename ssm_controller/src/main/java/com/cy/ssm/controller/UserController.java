package com.cy.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.ssm.pojo.User;
import com.cy.ssm.service.UserService;
import com.cy.ssm.utils.PhoneFormatCheckUtils;
import com.cy.ssm.utils.SendUtils;
import com.cy.ssm.utils.UUIDUtils;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	//实现登录功能
	@RequestMapping("/login")
	public String login(HttpSession session,Model model,User user){
		User user02=null;
		try {
			user02=userService.userLogin(user);
			//用户登录成功,将用户信息放入session中
			session.setAttribute("loginUser", user02);
			return "redirect:main.action";	
		} catch (Exception e) {
			//用户登录失败
			String msg=e.getMessage();
			//向request放入失败的信息
			model.addAttribute("msg",msg);
			return "jsp/login";
		}
	}
	
	//主界面登录按钮的跳转
	@RequestMapping("/mainlogin")
	public String mainlogin() {
		return "jsp/login";
	}
	
	@RequestMapping("/logout")
	//主界面退出功能实现
	public String logout(HttpSession session) {
		//清除session
		session.invalidate();
		//重新定向到首页
		return "redirect:main.action";
	}
	//主界面注册按钮的跳转
	@RequestMapping("/mainregister")
	public String mainregister() {
		return "jsp/register";
	}
	
	//主界面个人信息按钮的跳转
		@RequestMapping("/getmes")
		public String getmes() {
			return "jsp/message";
		}
	
		
	//主界面注册按钮的跳转
	@RequestMapping("/register")
	public String register(Model model,User user,HttpSession session,String telephone,String code) {
		// 为用户的其他属性赋值
		user.setUid(UUIDUtils.getId());
		//获取session的值
		String sysCode = (String)session.getAttribute("code");
		System.out.println(sysCode);
		String sysTel = (String)session.getAttribute("telephone");
		System.out.println(sysTel);
		if(sysCode.equals(code)&&sysTel.equals(telephone)) {
			userService.userRegister(user);
			model.addAttribute("msg", "用户注册成功,请登录!");
		}
		else {
			model.addAttribute("msg", "用户注册失败,请重新注册!");
			return "jsp/info";	
		}
		return "jsp/login";
	}
	@RequestMapping("/editmes")
	@ResponseBody //作用 把对象转成json字符串，并且回写浏览器
	public User edit(HttpSession session){
		User us = (User) session.getAttribute("loginUser");
		String id = us.getUid();
		return userService.findById(id);
	}
		
	/*	@RequestMapping("/updatemes")
	@ResponseBody //作用 把对象转成json字符串，并且回写浏览器
	public boolean update(User user){
		try {
			userService.updatemes(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}*/
	/**
	 * 发送验证码
	 * @param telephone
	 * @throws Exception 
	 */
	@RequestMapping("/sendCode")
	public void sendCode(String telephone,HttpServletResponse resp,HttpSession session) throws Exception {
		//判断手机号是否为空
		if(telephone==""||telephone==null) {
			resp.getWriter().println(3);
			//判断手机号是否合法
		}else if(!PhoneFormatCheckUtils.isPhoneLegal(telephone)) {
			resp.getWriter().println(1);
		}else{
			String code = userService.createSmsCode(telephone);
			session.setAttribute("telephone", telephone);
			session.setAttribute("code", code);
			resp.getWriter().println(2);
		}
	
		
	}
	

}
