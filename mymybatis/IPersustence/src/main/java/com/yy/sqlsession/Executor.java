package com.yy.sqlsession;

import com.yy.pojo.Configuration;
import com.yy.pojo.MappedStatement;

import java.util.List;

public interface Executor {

    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;

}
