package com.handwriting.mybatis;

import com.handwriting.domain.Blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author ZhenZhong
 * @date 2020/5/13
 */
public class Executor {


    private DataSourceProperties datasource;

    public Executor(DataSourceProperties datasource) {

        this.datasource = datasource;
    }

    public <T> T query(String sql, Object[] args) {
        try (Connection connection = DriverManager.getConnection(datasource.getUrl(), datasource.getUsername(), datasource.getPassword())) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(String.format(sql, args[0]))) {
                    while (resultSet.next()) {
                        Blog blog = new Blog();
                        blog.setId(resultSet.getInt("id"));
                        blog.setName(resultSet.getString("name"));
                        blog.setTitle(resultSet.getString("title"));
                        return (T) blog;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
