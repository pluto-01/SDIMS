package com.zed.service;

import com.zed.entity.User;

public interface LoginService {
    User select1(String username,String password);


    User select2(String username,String password);
}
