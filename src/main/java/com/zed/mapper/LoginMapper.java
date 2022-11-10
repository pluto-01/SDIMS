package com.zed.mapper;

import com.zed.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {
    /*
     *
     * 根据用户名及密码查询对象
     *
     * */
    @Select("select * from t_adminUser where username = #{username} and password = #{password}")
    User select1(@Param("username") String username, @Param("password") String password);

    @Select("select * from t_stuUser where username = #{username} and password = #{password}")
    User select2(@Param("username") String username, @Param("password") String password);

    @Select("select * from t_workerUser where username = #{username} and password = #{password}")
    User select3(@Param("username") String username, @Param("password") String password);
}
