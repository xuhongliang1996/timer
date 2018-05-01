package com.xhl.mapper;
 
import java.util.List;

import com.xhl.pojo.Category;
 
public interface CategoryMapper {
 
    public int add(Category category);  
      
    public List<Category> list();
    
}