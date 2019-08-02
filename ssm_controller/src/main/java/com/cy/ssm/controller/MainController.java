package com.cy.ssm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.ssm.pojo.Product;
import com.cy.ssm.service.ProductService;

@Controller
public class MainController {
	@Value("${mainsize}")
	private int mainsize;

	@Autowired
	private ProductService productService;

	//实现基础界面
	@RequestMapping("/main")
	public String list(Model model){
		//查询最热门商品
		List<Product> hots = productService.findHots(mainsize);
		//查询最新商品
		List<Product> news = productService.findNews(mainsize);
		
		//将数据放入model
		model.addAttribute("hots", hots);
		model.addAttribute("news",news);		
		return "jsp/index";
	}
	//实现后台基础界面
	@RequestMapping("/admin")
	public String showadmin(){		
		return "admin/main";
	}


}
