package com.javaman.webprojectlearn.pojo;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class testList {
    public static void main(String[] args) {
        List<Dept> list = new ArrayList<>();
        Dept dept = new Dept(1, "");
        Dept dept1 = new Dept(2, "xiaosan");
        Dept dept2 = new Dept(6, null);
        Dept dept3 = new Dept(5, "xiaosi");
        Dept dept4 =new Dept(10,"xiaosan");
        Dept dept5=new Dept(7,"xiaosan");
        Dept dept6=new Dept(null,"xiaosan");
        list.add(dept);
        list.add(dept1);
        list.add(dept2);
        list.add(dept3);
        list.add(dept4);
        list.add(dept5);
        list.add(dept6);
        List<Dept> collect = list.stream().sorted(Comparator.comparing(Dept::getDeptName, Comparator.nullsLast(String::compareTo)))
                //.sorted(Comparator.comparing(Dept::getId,Comparator.nullsLast(Integer::compareTo)))
                .collect(Collectors.toList());
        //List<Dept> collect1 = list.stream().sorted(Comparator.comparing(Dept::getId, Comparator.nullsLast(Integer::compareTo))).collect(Collectors.toList());
        //TODO
        //System.out.println(collect1);
        System.out.println(collect);
        // TODO: 2021/12/25

    }
}
