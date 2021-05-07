package com.yy.sqlsession;

import com.yy.pojo.Configuration;
import com.yy.pojo.MappedStatement;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @since 2021/5/7
 */
public class SimpleExecutor implements Executor {

    /**
     * 执行sql语句
     * @param configuration 含数据库配置、sql的信息
     * @param mappedStatement sql的唯一id
     * @param params 入参
     */
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception {
        // 1. 注册驱动，获取连接
        Connection connection = configuration.getDataSource().getConnection();

        // 2. 获取sql语句 : select * from user where id = #{id} and username = #{username}
        //转换sql语句： select * from user where id = ? and username = ? ，转换的过程中，还需要对#{}里面的值进行解析存储

        // 3.获取预处理对象：preparedStatement

        // 4. 设置参数
        //获取到了参数的全路径

        // 5. 执行sql

        // 6. 封装返回结果集
        return null;
    }
}
