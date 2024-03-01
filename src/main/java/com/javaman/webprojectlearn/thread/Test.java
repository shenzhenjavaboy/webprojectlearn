package com.javaman.webprojectlearn.thread;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:靓仔
 * @Since：2024/02/23
 * @Description:
 */
public class Test {
    private static String message="hello";
    public static void main(String[] args) /*throws NullPointerException*/ {

        String a="he";
        String b="llo";
        String c=a+b;
        String d=new String("hello");
        String e="he"+"llo";
        System.out.println(c==message);//false c先检测常量池，然后在堆中创建一个新的对象；message属于常量池
        System.out.println(d==message);//false d创建了两个空间，一个是new string类，存储在堆中，接着创建字符串对象，存储在常量池；message属于常量池
        System.out.println(e==message);//true  e和message指向常量池中的同一块空间
       /* List<BizSupplier> cooPartList=new ArrayList<>();
        List<BizSupplier> suppList=new ArrayList<>();
        Set<List<BizSupplier>> lists=new HashSet<>();
        Map<Date, List<BizSupplier>> map = cooPartList.stream().collect(Collectors.groupingBy(BizSupplier::getPlanDate));
        map.forEach(
                (k,v)->{
                    suppList.forEach(
                            o->{
                                if (o.getStartDate().before(k)&&o.getEndDate().after(k)){
                                    lists.add(v);
                                }
                            }
                    );
                }
        );

        System.gc();*/

    }

}
