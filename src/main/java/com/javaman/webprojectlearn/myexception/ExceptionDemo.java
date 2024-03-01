package com.javaman.webprojectlearn.myexception;

public class ExceptionDemo {
    public static void main(String[] args) {
        int a=0;
        int b=1;
        try {
            System.out.println(b/a);
        }catch (NullPointerException e){
            System.out.println("除数不能为0");
        }finally {
            System.out.println("我是finally代码块");
        };
        System.out.println("111");
    }
}
class demo1{
    public void test1() throws Exception{
        int a=0;
        int b=1;

        System.out.println("connect successfuly");
    }
}
