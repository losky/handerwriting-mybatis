package com.handwriting.mybatis;


/**
 * @author ZhenZhong
 * @date 2020/5/13
 */
public class SqlSession {
    private final Configuration configuration;
    private final Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId, Object... args) {
        String sql = configuration.getSql(statementId);
        return executor.query(sql, args);
    }

    public <T> T getMapper(Class clazz) {
        return configuration.getMapper(clazz, this);
    }
}
