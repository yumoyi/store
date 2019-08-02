package com.cy.ssm.mapper;

import com.cy.ssm.pojo.Category;
import com.cy.ssm.pojo.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    int countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(String cid);

    void insert(Category record);

    void insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(String cid);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    void updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

	List<Category> findByName(Category category);
	
	List<Category> findAll();

	Category findkindajax(String cname);
}