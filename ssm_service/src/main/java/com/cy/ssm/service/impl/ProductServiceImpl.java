package com.cy.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.ssm.mapper.ProductMapper;
import com.cy.ssm.pojo.Product;
import com.cy.ssm.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	//主页面查询最新商品
	public List<Product> findHots(int mainsize) {
		return productMapper.findHots(mainsize);
	}

	@Override
	//主页面查询最新商品
	public List<Product> findNews(int mainsize) {
		return productMapper.findNews(mainsize);
	}

}