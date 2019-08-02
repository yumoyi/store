package com.cy.ssm.service;

import com.cy.ssm.pojo.Category;
import com.github.pagehelper.PageInfo;

public interface KindService {
	//查询全部分类信息
	public PageInfo<Category> selectkind(int page, int size);

	public void addkind(Category category);

	public PageInfo<Category> adminkindfind(Category category,int page,int size);

	public void delkind(String cid);

	public void upkind(Category category);

	public Category findkindajax(String cname);

}
