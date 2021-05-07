package com.yy.sqlsession;

import com.yy.pojo.Configuration;

/**
 * SqlSession工厂
 * @since 2021/5/7
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration configuration;
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
