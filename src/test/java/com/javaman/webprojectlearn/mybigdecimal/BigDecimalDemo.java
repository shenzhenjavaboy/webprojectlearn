package com.javaman.webprojectlearn.mybigdecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BigDecimalDemo {
    @Test
    public void fun1(){
        BigDecimal bigDecimal=new BigDecimal("10000.00011");
        System.out.println(bigDecimal.toString());
    }
    @Test
    public void fun2(){
        int num=0;
        int[] arr={1,3,5,7,9};
        for (int i=0;i<arr.length;i++){
            if (arr[i]==7){
                continue;
            }
            System.out.println("我输出了"+arr[i]);
        }

    }
    @Test
    public void fun3(){
        int num=0;
        int[] arr={1,3,5,7,9};
        for (int i=0;i<arr.length;i++){
            if (arr[i]==7){
                break;
            }
            System.out.println("我输出了"+arr[i]);
        }

    }
}
