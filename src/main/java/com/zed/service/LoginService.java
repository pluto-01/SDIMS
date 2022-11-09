package com.zed.service;

import com.zed.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoginService {
    User select1(String username,String password);


    User select2(String username,String password);
}
