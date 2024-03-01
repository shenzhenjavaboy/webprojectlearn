package com.javaman.webprojectlearn.myjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonDemo {
    //json字符串
    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public static void main(String[] args) {
//        JSONObject jsonObject= JSON.parseObject(JSON_OBJ_STR);
//        Object studentName = jsonObject.getString("studentName");
//        System.out.println(studentName);
          Student stu=new Student();
        stu.setId(1);
        stu.setSex("man");
        //stu.setName("xiaoming");

        //Student   三个属性:int id,String name,String sex
        List<Student> list=new ArrayList<>();
        Student s1=new Student();
        s1.setName("xiaowang");
        s1.setSex("man");
        s1.setId(2);

        Student s2=new Student();
        s1.setName("xiaoqiang");
        s1.setSex("man");
        s1.setId(3);
        list.add(s1);
        list.add(s2);
        String str=JSONObject.toJSONString(list);

        System.out.println(list);


        //String s="[{\"name\":\"lily\",\"id\":12,\"sex\":\"man\"},{\"name\":\"lucy\",\"id\":13,\"sex\":\"woman\"}]";
        String sss="[{\"id\":\"111\",\"name\":\"xiaohong\",\"sex\":\"woman\"},{\"id\":\"111\",\"name\":\"xiaohong\",\"sex\":\"woman\"}]";
        List<Student> student=JSONObject.parseArray(sss,Student.class);

        System.out.println(student);
    }
}
