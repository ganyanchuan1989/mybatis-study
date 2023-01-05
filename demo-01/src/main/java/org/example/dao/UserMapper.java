package org.example.dao;

import org.example.entry.User;

import java.util.List;

public interface UserMapper {

    List<User> queryAllUser();

    User queryUserById(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(int id);
}
