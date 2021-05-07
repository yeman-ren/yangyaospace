package com.yy.dao;

import com.yy.pojo.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户
     */
    List<User> findAll() throws Exception;

    /**
     * 查询一条数据
     */
    User findOne(Long id) throws Exception;

    /**
     * 插入一条数据
     */
    void addOne(User user) throws Exception;

    /**
     * 删除一条数据
     */
    void delOne(Long id) throws Exception;

    /**
     * 修改一条数据
     */
    void updateOne(User user) throws Exception;
}
