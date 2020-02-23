/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CategoryController
 * Author:   jiamengfei3
 * Date:     2020/2/23 15:32
 * Description: 分类功能前端
 */
package com.jmf.tmall.controller;


import com.jmf.tmall.pojo.Category;
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
        List<Category> cs= categoryService.list();
        System.out.println();
        model.addAttribute("cs", cs);
        return "admin/listCategory";
    }
}