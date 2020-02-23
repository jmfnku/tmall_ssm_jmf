/**
 * Copyright (C), 2015-2020, 京东
 * FileName: TestTmall
 * Author:   jiamengfei3
 * Date:     2020/2/23 16:11
 * Description: 测试类
 */
package com.jmf.tmall.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * 测试类
 *
 * @author: jiamengfei3
 * @Date: 2020/02/23 16:11
 * @since: 1.0.0
 */
public class TestTmall {

    public static void main(String args[]) {
        //准备分类测试数据：

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&characterEncoding=utf8",
                        "root", "admin");
                Statement s = c.createStatement();
        ) {
            for (int i = 1; i <= 10; i++) {
                String sqlFormat = "insert into category values (null, '测试分类%d')";
                String sql = String.format(sqlFormat, i);
                s.execute(sql);
            }

            System.out.println("已经成功创建10条分类测试数据");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}