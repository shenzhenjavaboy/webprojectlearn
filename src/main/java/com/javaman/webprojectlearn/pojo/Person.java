package com.javaman.webprojectlearn.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.spel.SpelNode;
import org.springframework.stereotype.Component;

@Component
public class Person {
    public static void main(String[] args) {
        Person person=new Person();
        System.out.print(person.toString());
    }
    @Value("1")
    private int id;

    @Value("zhangsan")
    private String name;

    @Bean
    public String hallo(){
        return "hallo";
    }
    public Person() {
        System.out.println("Person的无参构造方法执行了。。");
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Person的有参构造方法执行了。。");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
