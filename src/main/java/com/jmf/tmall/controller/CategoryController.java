/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CategoryController
 * Author:   jiamengfei3
 * Date:     2020/2/23 15:32
 * Description: 分类功能前端
 */
package com.jmf.tmall.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmf.tmall.pojo.Category;
import com.jmf.tmall.pojo.Page;
import com.jmf.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * 分类功能前端
 *
 * @author: jiamengfei3
 * @Date: 2020/02/23 15:32
 * @since: 1.0.0
 */
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model){
        Page page = new Page(5,5);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> cs= categoryService.list();
        int total = (int)new PageInfo<>(cs).getTotal();
        System.out.println(cs);
        System.out.println(total);
        model.addAttribute("cs", cs);
        model.addAttribute("total",total);
        return "admin/listCategory";
    }

    @RequestMapping("admin_category_add")
    public String add(){
        Category category = new Category();
        category.setName("dashabi");
        int c = categoryService.add(category);
        return "";
    }
    //master回退测试2

}