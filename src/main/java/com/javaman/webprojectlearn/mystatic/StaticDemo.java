package com.javaman.webprojectlearn.mystatic;

public class StaticDemo {
    public static void main(String[] args) {
        MyStatic.getSum();
        MyStatic.temp=9;
        MyStatic.i=10;

        int sum=MyStatic.getSum();
        System.out.println(sum);
    }
}
