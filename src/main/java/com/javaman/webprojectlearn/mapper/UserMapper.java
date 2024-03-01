package com.javaman.webprojectlearn.mapper;

import com.javaman.webprojectlearn.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
    List<User> getUser();
}
