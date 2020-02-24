package com.jmf.tmall.service;

import com.jmf.tmall.pojo.Category;
import com.jmf.tmall.pojo.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list(Page page);
    int total();
}
