package com.handwriting.mybatis;

import java.util.ResourceBundle;

/**
 * @author ZhenZhong
 * @date 2020/5/13
 */
public class DataSourceProperties {
    private final String name;
    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;

    public DataSourceProperties(ResourceBundle datasource) {
        this.name = datasource.getString("name");
        this.driverClassName = datasource.getString("driver-class-name");
        this.url = datasource.getString("url");
        this.username = datasource.getString("username");
        this.password = datasource.getString("password");
    }

    public String getName() {
        return name;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
