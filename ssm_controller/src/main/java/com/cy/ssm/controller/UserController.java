package com.cy.ssm.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.ssm.pojo.User;
import com.cy.ssm.service.UserService;
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
	public String register(Model model,User user) {
		// 为用户的其他属性赋值
		user.setUid(UUIDUtils.getId());
		// 调用业务层注册功能
		try {
				userService.userRegister(user);
				model.addAttribute("msg", "用户注册成功,请登录!");
				
			} catch (Exception e) {
				// 注册失败,跳转到提示页面
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

}
