package com.xhl.service;

import java.util.List;

import com.xhl.pojo.Category;

public interface CategoryService {

	List<Category> list();
	
	int add(Category category);
}
