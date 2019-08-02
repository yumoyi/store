package com.cy.ssm.mapper;

import java.util.List;

import com.cy.ssm.pojo.Product;

public interface ProductMapper {

    //主页面查询最新商品
	public List<Product> findHots(int mainsize);
	 //主页面查询最新商品
	public List<Product> findNews(int mainsize);
}
