/**
 * Copyright (C), 2015-2020, 京东
 * FileName: MyPlugin
 * Author:   jiamengfei3
 * Date:     2020/3/17 18:36
 * Description: 自定义插件
 */
package com.jmf.tmall.mapper;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 *
 * 自定义插件
 *
 * @author: jiamengfei3
 * @Date: 2020/03/17 18:36
 * @since: 1.0.0
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class})})
public class MyPlugin implements Interceptor {

    private int limit;
    private String dbType;
    private static final String LIMIT_TABLE_NAME = "limit_table_name_xxxx";
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler);
        while(metaObject.hasGetter("h")){
            Object obj = metaObject.getValue("h");
            metaObject = MetaObject.forObject(obj);
        }
        while(metaObject.hasGetter("target")){
            Object obj = metaObject.getValue("target");
            metaObject = MetaObject.forObject(obj);
        }
        String sql = (String) metaObject.getValue("delegate.boundSql.sql");
        String limitSql;
        if ("mysql".equals(this.dbType) && sql.indexOf(LIMIT_TABLE_NAME) == -1){
            sql = sql.trim();
            limitSql = "select * from ("+sql+")"+LIMIT_TABLE_NAME+" limit "+limit;
            metaObject.setValue("delegate.boundSql.sql",limitSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
        String strLimit = properties.getProperty("limit","5");
        this.limit = Integer.parseInt(strLimit);
        this.dbType = properties.getProperty("dbType","mysql");
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }
}