package com.zed.service.impl;

import com.zed.entity.User;
import com.zed.mapper.LoginMapper;
import com.zed.service.LoginService;
import com.zed.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LoginServiceImpl implements LoginService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public User select1(String username, String password) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取Mapper
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        //调用方法
        User user1 = loginMapper.select1(username, password);
        //释放资源
        sqlSession.close();

        return user1;
    }

    @Override
    public User select2(String username, String password) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取Mapper
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        //调用方法
        User user2 = loginMapper.select2(username, password);
        //释放资源
        sqlSession.close();

        return user2;
    }

    @Override
    public User select3(String username, String password) {
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取Mapper
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        //调用方法
        User user3 = loginMapper.select3(username, password);
        //释放资源
        sqlSession.close();

        return user3;
    }

}
