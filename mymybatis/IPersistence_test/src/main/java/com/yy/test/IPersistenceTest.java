package com.yy.test;

import com.yy.dao.IUserDao;
import com.yy.io.Resources;
import com.yy.pojo.User;
import com.yy.sqlsession.SqlSession;
import com.yy.sqlsession.SqlSessionFactory;
import com.yy.sqlsession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试自定义的mybatis
 * @since 2021/5/6
 */
public class IPersistenceTest {


    @Test
    public void testIPersistence() throws Exception {
        //读取配置文件，转为inputStream流
        InputStream inputStream = Resources.getResourceAsSteam("src/main/resources/config/SqlMapConfig.xml");

        //获取sqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //1查询sql
        User user = new User();
        user.setId(1L);
        User user1 = sqlSession.selectOne("com.yy.dao.IUserDao.findOne", user);
        System.out.println(user1);

        //2查询列表
        List<User> users = sqlSession.selectList("com.yy.dao.IUserDao.selectList");
        for (User user2 : users) {
            System.out.println(user2);
        }

        //3为Dao接口生成代理实现类
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        List<User> all = userDao.findAll();
        for (User user3 : all) {
            System.out.println(user3);
        }
    }

}
