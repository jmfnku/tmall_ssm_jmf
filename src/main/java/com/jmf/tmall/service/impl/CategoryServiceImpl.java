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
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }

    @Override
    public int total() {
        return categoryMapper.total();
    }
}