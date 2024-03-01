package com.javaman.webprojectlearn.reflect;

import com.javaman.webprojectlearn.pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflect {
    public static void main(String[] args) {
        User user=new User();
        user.setSex("man");
        user.setTelphone("110");
        user.setName("zhangsan");
        //.getclass()获取该类的class对象
        Class<? extends User> aClass = user.getClass();
        String str="UserName";
        String methodName="get"+str;
        try {
            //.getDeclaredMethod()返回一个Method对象，它反映此Class对象所表示的类或接口的指定已声明方法
            // 该方法有两个参数，第一个参数为方法名，第二个参数是一个数组的Class对象识别方法的形参类型，用.class传递，
            //比如要传一个String类型参数，就传String.class
            Method method = aClass.getDeclaredMethod(methodName);
            //method.invoke(Object obj,Object args[])的作用就是调用method类代表的方法，其中obj是对象名，args是传入method方法的参数
            Object invoke = method.invoke(user);
            System.out.println(invoke);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
