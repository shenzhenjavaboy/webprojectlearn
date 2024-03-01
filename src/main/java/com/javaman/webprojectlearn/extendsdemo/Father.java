package com.javaman.webprojectlearn.extendsdemo;


import org.springframework.data.relational.core.sql.In;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.IntStream;

public class Father  {
    public static void main(String[] args){
        //
       /* long test = test(30);
        System.out.println(test);*/
        List<Integer> count = count(getList());
        System.out.println(count);
    }
    public static long test(int num){
        long a = 0;
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(0L, 0L, 1L));
        for (int i = 0; i <=num ; i++) {
            if (i>=3){
               a=list.get(i-1)+list.get(i-2)+ list.get(i-3);
               list.add(a);
            }
        }
        return a;
    }
    public static List<Set<Integer>> getList(){
        Random random=new Random();
        List<Set<Integer>> list=new ArrayList<>();
        for (int j = 0; j <101 ; j++) {
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i <201 ; i++) {
                set.add(random.nextInt(10000));
            }
            list.add(set);
        }
        System.out.println(list);
        return list;

    }
    public static List<Integer> count(List<Set<Integer>> lists){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (Set<Integer> set : lists) {
            for (Integer integer : set) {
                map.merge(integer, 1, Integer::sum);
            }
        }
        List<Integer> list=new ArrayList<>();
        map.forEach(
                (k,v)->{
                    if (v>10){
                        list.add(k);
                    }
                }
        );
        return list;
    }
}


