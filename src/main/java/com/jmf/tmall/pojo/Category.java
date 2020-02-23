/**
 * Copyright (C), 2015-2020, 京东
 * FileName: Category
 * Author:   jiamengfei3
 * Date:     2020/2/23 13:13
 * Description: 分类
 */
package com.jmf.tmall.pojo;


/**
 *
 * 分类
 *
 * @author: jiamengfei3
 * @Date: 2020/02/23 13:13
 * @since: 1.0.0
 */
public class Category {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}