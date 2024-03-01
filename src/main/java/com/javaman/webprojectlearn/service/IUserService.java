package com.javaman.webprojectlearn.service;

import com.javaman.webprojectlearn.pojo.User;

import java.util.List;

public interface IUserService {
    //查询用户
    public List<User> query() throws Exception;

    //增加用户
    public Integer addUser(User user);

    //修改用户
    public Integer updateUser(User user);

    //删除用户
    public Integer deleteUser(User user);

    //java 导入导出工作表
    public void getExcel();

}
