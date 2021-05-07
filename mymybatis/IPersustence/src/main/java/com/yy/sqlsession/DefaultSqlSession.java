package com.yy.sqlsession;

import com.yy.pojo.Configuration;
import com.yy.pojo.MappedStatement;

import java.util.List;

/**
 * @since 2021/5/7
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 查询一条数据
     * @param statementid sql的唯一标识
     * @param params 入参
     */
    @Override
    public <T> T selectOne(String statementid, Object... params) throws Exception {
        List<T> objects = selectList(statementid, params);
        if(objects.size()==1){
            return (T) objects.get(0);
        }else {
            throw new RuntimeException("查询结果为空或者返回结果过多");
        }
    }

    /**
     * 查询所有
     * @param statementid sql的唯一标识
     * @param params 入参
     */
    @Override
    public <E> List<E> selectList(String statementid, Object... params) throws Exception {
        //将要去完成对simpleExecutor里的query方法的调用
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementid);
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);
        return (List<E>) list;
    }
}
