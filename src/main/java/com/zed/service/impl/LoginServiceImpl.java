package com.zed.service.impl;

import com.zed.entity.User;
import com.zed.service.LoginService;
import com.zed.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSessionFactory;

public class LoginServiceImpl implements LoginService {
    //创建SqlSessionFactory对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public User select1(String username, String password) {
        return null;
    }

    @Override
    public User select2(String username, String password) {
        return null;
    }

}
