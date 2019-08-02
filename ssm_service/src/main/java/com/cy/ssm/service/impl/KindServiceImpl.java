package com.cy.ssm.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.ssm.mapper.CategoryMapper;
import com.cy.ssm.pojo.Category;
import com.cy.ssm.service.KindService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class KindServiceImpl implements KindService {
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public PageInfo<Category> selectkind(int page, int size) {

		PageHelper.startPage(page, size);	
		List<Category> list = categoryMapper.findAll();
		PageInfo<Category> pageinfo =new PageInfo<Category>(list);
		/*System.out.println("总数量：" + pageinfo.getTotal());
		System.out.println("当前页查询记录：" + pageinfo.getList().size());
		System.out.println("当前页码：" + pageinfo.getPageNum());
		System.out.println("每页显示数量：" + pageinfo.getPageSize());
		System.out.println("总页：" + pageinfo.getPages());*/
		return pageinfo;
	}

	@Override
	public void addkind(Category category) {
		categoryMapper.insertSelective(category);
	}

	@Override
	public PageInfo<Category> adminkindfind(Category category,int page, int size) {
		
		PageHelper.startPage(page, size);	
		List<Category> list = categoryMapper.findByName(category);
		PageInfo<Category> pageinfo =new PageInfo<Category>(list);
		return pageinfo;
	}

	@Override
	public void delkind(String cid) {
		categoryMapper.deleteByPrimaryKey(cid);
		
	}

	@Override
	public void upkind(Category category) {
		categoryMapper.updateByPrimaryKeySelective(category);
	}

	@Override
	public Category findkindajax(String cname) {
		return categoryMapper.findkindajax(cname);
	}



	

}
