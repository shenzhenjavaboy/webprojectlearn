package com.javaman.webprojectlearn.mycollections;

import com.javaman.webprojectlearn.pojo.User;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class CollectionsDemo {
    @Test
    public void fun1(){
        List list= Arrays.asList("zhangsan lisi wangwu zhaoliu hengqi shuba".split(" "));
        Collections.reverse(list);
        System.out.println(list);
    }
    @Test
    public void fun2(){
        List<Integer> list=new ArrayList<>();
        list=Arrays.asList(1,2,3,5,3,6,9,7);
        System.out.println("最小值："+Collections.min(list));
        System.out.println("最大值："+Collections.max(list));
    }

    @Test
    public void fun4(){
        List<Map<String,List<String>>> list=new ArrayList<>();
        HashMap<String,List<String>> mapa=new HashMap<String, List<String>>(){{}};
        HashMap<String,List<String>> mapb=new HashMap<String, List<String>>(){{
            put("super star",Arrays.asList("吴签","成龙","李连杰","陈冠希"));
            put("hobby",Arrays.asList("抽烟","喝酒","烫头","约炮"));
            put("city",Arrays.asList("beijing","wuhan","nanjing","shanghai"));
            put("country",Arrays.asList("china","japan","America","russia"));
        }};

        list.add(mapa);
        list.add(mapb);
        System.out.println(list);
        for (Map<String,List<String>> map:list) {
            for (String str:map.keySet()) {
//                System.out.println(str);
                for (String string : map.get(str)) {

                    if ("吴签".equals(string)){
                        System.out.println(string+":我的很大，你忍一下，，");
                    }
                    else {
                        System.out.println(string);
                    }
                }
            }
        }
    }
    @Test
    public void test1(){
        List<String> list = Collections.singletonList("1");
    }
    @Test
    public void fun6(){
        Integer a=-1280,b=-1280;
        if (a.equals(b)){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
