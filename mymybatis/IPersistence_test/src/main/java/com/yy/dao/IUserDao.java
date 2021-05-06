package com.yy.dao;

import com.yy.pojo.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户
     * @return 1
     * @throws Exception
     */
    List<User> findAll() throws Exception;
}
