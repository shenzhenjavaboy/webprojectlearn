package com.javaman.webprojectlearn.dao.impl;

import com.javaman.webprojectlearn.dao.IUserDao;
import com.javaman.webprojectlearn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询用户
    @Override
    public List<User> query() throws Exception {
        List<User> list=jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("username"));
                user.setSex(resultSet.getString("sex"));
                user.setTelphone(resultSet.getString("telphone"));
                return user;
            }
        });
        return list;
    }

    //增加用户
    @Override
    public Integer addUser(User user) {
        String sql="insert into user(name,sex,telphone) values(?,?,?)";
        Integer result=jdbcTemplate.update(sql,user.getName(),user.getSex(),user.getTelphone());
        return result;
    }

    //删除用户
    @Override
    public Integer deleteUser(User user) {
        String sql = "delete from user where telphone=?";
        Integer result=jdbcTemplate.update(sql,user.getTelphone());
        return result;
    }

    //修改用户
    @Override
    public Integer updateUser(User user) {
        String sql="update user set sex=? where telphone=?";
        Integer result=jdbcTemplate.update(sql,user.getSex(),user.getTelphone());
        return result;
    }
}
