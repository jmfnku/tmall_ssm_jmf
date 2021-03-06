/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CategoryServiceImpl
 * Author:   jiamengfei3
 * Date:     2020/2/23 15:30
 * Description: 分类服务实现类
 */
package com.jmf.tmall.service.impl;


import com.jmf.tmall.mapper.CategoryMapper;
import com.jmf.tmall.pojo.Category;
import com.jmf.tmall.pojo.Page;
import com.jmf.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 分类服务实现类
 *
 * @author: jiamengfei3
 * @Date: 2020/02/23 15:30
 * @since: 1.0.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    /*@Override
    public int total() {
        return categoryMapper.total();
    }*/

    @Override
    public int add(Category category) {
        return categoryMapper.add(category);
    }

    @Override
    public int delete(Category category) {
        return categoryMapper.delete(category);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }
}