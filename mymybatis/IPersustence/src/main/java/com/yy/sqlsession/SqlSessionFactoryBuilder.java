package com.yy.sqlsession;

import com.yy.config.XMLConfigBuilder;
import com.yy.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * SqlSessionFactory构造器
 * @since 2021/5/6
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException {
        // 第一：使用dom4j解析配置文件，将解析出来的内容封装到Configuration中。 configuration包含数据库配置、具体的mapper的每个对象
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);

        // 第二：创建sqlSessionFactory对象：工厂类：生产sqlSession:会话对象
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        return defaultSqlSessionFactory;

    }


}
