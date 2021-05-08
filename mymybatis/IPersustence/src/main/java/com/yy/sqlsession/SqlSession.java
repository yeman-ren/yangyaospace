package com.yy.sqlsession;

import java.util.List;

/**
 * @since 2021/5/7
 */
public interface SqlSession {

    /**
     * 查询一条数据
     * @param statementid sql的唯一标识
     * @param params 入参
     */
    <T> T selectOne(String statementid,Object... params) throws Exception;

    /**
     * 查询所有
     * @param statementid sql的唯一标识
     * @param params 入参
     */
    <E> List<E> selectList(String statementid, Object... params) throws Exception;

    /**
     * 为Dao接口生成代理实现类
     * @param mapperClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<?> mapperClass);
}
