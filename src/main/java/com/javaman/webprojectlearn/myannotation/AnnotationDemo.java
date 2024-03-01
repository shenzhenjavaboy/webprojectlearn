package com.javaman.webprojectlearn.myannotation;

public class AnnotationDemo {
    @Deprecated//功能过时，不建议使用，但是可以用
    public static void fun1(){
        System.out.println("我过时了，，");

    }
    public static void fun2(){
        System.out.println("我是fun1的功能扩展，，");
    }

    public static void main(String[] args) {
        fun1();
        fun2();
    }
}
