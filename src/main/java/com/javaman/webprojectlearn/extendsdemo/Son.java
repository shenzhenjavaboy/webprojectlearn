package com.javaman.webprojectlearn.extendsdemo;

import java.util.HashMap;
import java.util.Map;

public class Son extends Father {

    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.merge(1,1,Integer::sum);
        System.out.println(map);
        
    }
}
