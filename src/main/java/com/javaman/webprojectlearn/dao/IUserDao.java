package com.javaman.webprojectlearn.dao;

import com.javaman.webprojectlearn.pojo.User;

import java.util.List;

public interface IUserDao {
    //查询用户
    public List<User> query() throws Exception;

    //增加用户
    public Integer addUser(User user);

    //修改用户
    public Integer updateUser(User user);

    //删除用户
    public Integer deleteUser(User user);
}
