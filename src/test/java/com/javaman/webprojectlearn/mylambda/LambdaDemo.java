package com.javaman.webprojectlearn.mylambda;

import org.junit.Test;

import java.util.*;

public class LambdaDemo {
    @Test
    public void fun1(){
        List list = Arrays.asList("name", "sex", "height", "age");
        list.stream().forEach(str->{
            System.out.println(str);
        });
    }

    @Test
    public void fun2(){
        Map<String,String> map=new HashMap();
        map.put("name","zhangsan");
        map.put("age","18");
        map.put("sex","man");
        map.forEach((String k,String v)->{
            System.out.println(k+" "+v);
        });

    }
}
