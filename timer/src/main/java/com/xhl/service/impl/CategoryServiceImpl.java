package com.xhl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhl.mapper.CategoryMapper;
import com.xhl.pojo.Category;
import com.xhl.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;
	
	public List<Category> list(){
		return categoryMapper.list();
	}

	@Override
	public int add(Category category) {
		return categoryMapper.add(category);
	}


}
