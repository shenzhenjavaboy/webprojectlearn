package com.javaman.webprojectlearn.mystream;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    @Test
    public void fun1() {
        List<Integer> list = new ArrayList<>();
        list = Arrays.asList(11, 52, 23, 44, 51, 16);
        //过滤元素
        List<Integer> newlist = list.stream().filter(num -> num != 11 && num != 23).collect(Collectors.toList());
        //foreach循环
        list.stream().forEach(integer -> System.out.println(integer));
        System.out.println(newlist);
        //map  用于映射元素到对应的结果,下面是将每个元素平方
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = list1.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(list2);
        //.distinct()  去重
        List<String> str = Arrays.asList("aa", "aa", "bb", "c", "c", "d");
        List<String> strings = str.stream().distinct().collect(Collectors.toList());
        System.out.println("非重复个数:" + str.stream().distinct().count());
        System.out.println(strings);
        //limit 用于获取指定数量的流
        List<Integer> integers = Arrays.asList(2, 3, 2, 4, 5, 7, 77, 1);
        List<Integer> ii = integers.stream().limit(3).collect(Collectors.toList());
        System.out.println(ii);
    }

    @Test
    public void fun2() {
        LocalDate localDate = LocalDate.now();
        List<String> listDate = Arrays.asList("2020-10-02", "2020-08-03", "2020-07-20", "2020-11-11", "2020-03-02", "2020-07-22");
        List<String> list = listDate.stream().flatMap(s -> {
            String[] str = s.split("-");
            Stream<String> stream = Arrays.stream(str);
            return stream;
        }).collect(Collectors.toList());

        System.out.println(list);


    }

    @Test
    public void fun3() {
        /*List<Integer> list=Arrays.asList(1,2,3,4,5,6,null,7,5,32,45,65);
        Dept dept = new Dept(1, "销售");
        Dept dept1=new Dept(2,"文员");

        List<Dept> deptList=Arrays.asList(dept,dept1);
        Integer integer=list.stream().filter(n->n!=null).max(Integer::compareTo).get();
        System.out.println(integer);*/
        List<String> list = Arrays.asList("1", "da", "dssf", "2022-05-03", null, "2020-01-01", "fjo", null, "2021-05-04");
        List<LocalDate> list1 = list.stream().filter(
                k -> k != null
        ).filter(
                k -> {
                    if (k.contains("-")) {
                        return true;
                    }
                    return false;
                }
        ).distinct().map(LocalDate::parse).sorted().collect(Collectors.toList());
        System.out.println(list1);
        System.out.println("  wo ke zhen xing   gan diao zheme duo  dongxi ");

    }

}
