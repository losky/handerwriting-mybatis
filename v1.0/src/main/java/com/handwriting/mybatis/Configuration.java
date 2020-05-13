package com.handwriting.mybatis;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @author ZhenZhong
 * @date 2020/5/13
 */
public class Configuration {
    private static final ResourceBundle resourceBundle;

    static {
        resourceBundle = ResourceBundle.getBundle("sql");
    }

    public String getSql(String statementId) {
        return resourceBundle.getString(statementId);
    }

    public <T> T getMapper(Class clazz, SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new MapperProxy(sqlSession));
    }
}
