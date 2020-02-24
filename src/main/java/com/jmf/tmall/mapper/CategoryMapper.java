package com.jmf.tmall.mapper;

import com.jmf.tmall.pojo.Category;
import com.jmf.tmall.pojo.Page;

import java.util.List;

public interface CategoryMapper {
    List<Category> list(Page page);
    int total();
}
