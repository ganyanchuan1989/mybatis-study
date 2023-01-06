package org.example.dao;

import org.apache.ibatis.annotations.*;
import org.example.entry.User;

import java.util.List;

public interface UserMapper {

    /**
     * 采用注解的方式
     *
     * @return
     */
    @Select("select * from com_user;")
    List<User> queryAllUser();

    @Select("select * from com_user where id=#{id};")
    User queryUserById(@Param("id") int id);

    @Delete("delete from com_user where id=#{id}")
    int deleteUserById(@Param("id") int id);

    @Insert("insert into com_user(name, password) value(#{name}, #{password});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    @Update("update com_user set name=#{name}, password=#{password} where id#={id}")
    int updateUser(User user);
}
