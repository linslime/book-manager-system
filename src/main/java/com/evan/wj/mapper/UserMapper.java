package com.evan.wj.mapper;

import com.evan.wj.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where username = #{userName}")
    User findByUserName(String userName);

    @Select("select * from user where userName = #{userName} and password = #{password}")
    User getByUserNameAndPassword(String userName,String password);
}
