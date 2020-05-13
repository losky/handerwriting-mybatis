package com.handwriting.mybatis;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 * @author ZhenZhong
 * @date 2020/5/13
 */
public class Configuration {
    private static final ResourceBundle sqlBinding;
    private static final ResourceBundle datasource;

    static {
        sqlBinding = ResourceBundle.getBundle("sql");
        datasource = ResourceBundle.getBundle("datasource");
    }

    public DataSourceProperties getDatasource() {
        return new DataSourceProperties(datasource);
    }

    public String getSql(String statementId) {
        return sqlBinding.getString(statementId);
    }

    public <T> T getMapper(Class clazz, SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new MapperProxy(sqlSession));
    }
}
