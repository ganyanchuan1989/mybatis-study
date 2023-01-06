package org.example.dao;

import org.example.entry.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> queryAllUser();

    User queryUserById(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(int id);

    List<User> queryUserByLimit(Map<String, Object> map);
}
