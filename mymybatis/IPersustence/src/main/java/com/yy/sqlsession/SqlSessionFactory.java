package com.yy.sqlsession;

/**
 * SqlSession工厂
 * @since 2021/5/6
 */
public interface SqlSessionFactory {

    /**
     * 获取sqlSession
     */
    SqlSession openSession();
}
