package com.cy.ssm.service;

import java.util.List;

import com.cy.ssm.pojo.Product;

public interface ProductService {
	//主页面查询最新商品
	public List<Product> findHots(int mainsize);
	//主页面查询最新商品
	public List<Product> findNews(int mainsize);

}
