package com.javaman.webprojectlearn;

import com.javaman.webprojectlearn.pojo.Person;
import com.javaman.webprojectlearn.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.javaman.webprojectlearn.")
public class WebprojectlearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebprojectlearnApplication.class, args);
    }

}
