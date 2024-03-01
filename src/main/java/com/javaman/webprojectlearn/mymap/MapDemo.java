package com.javaman.webprojectlearn.mymap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,Object> map=new HashMap<>();
        map.put("name","xiaoming");
        map.put("sex","man");
        List<Map<String,Object>> list= new ArrayList<Map<String, Object>>();
        list.add(map);
        System.out.println(list);
        List<Map<String,Object>> list1= (List<Map<String, Object>>) list.stream().sorted();
        System.out.println(list1);
    }
}
