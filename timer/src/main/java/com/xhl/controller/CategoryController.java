package com.xhl.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhl.pojo.Category;
import com.xhl.service.CategoryService;
import com.xhl.util.Page;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/listCategory")
	public ModelAndView listCategory(Page page){
		ModelAndView mav = new ModelAndView();
		
		PageHelper.offsetPage(page.getStart(),10);
		List<Category> cs= categoryService.list();
		int total = (int) new PageInfo<>(cs).getTotal();
		page.caculateLast(total);
		
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		return mav;
	}
	
    // 设置执行时间
    // spring cron 表达式介绍  http://www.blogjava.net/lcs868/articles/246649.html
    // "0/10 * * * * *" 表示从第0秒开始每隔10秒执行一次
    @Scheduled(cron = "0/10 * * * * *")
    public void addCategory(){
    	Category c = new Category();
    	Date day=new Date();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	String f = "定时添加：" + df.format(day);
    	c.setName(f);
    	// 调用service层的方法向数据库中插入数据
    	categoryService.add(c);
    }
}
