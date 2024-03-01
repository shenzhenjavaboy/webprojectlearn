package com.javaman.webprojectlearn.stream;

import com.google.common.collect.Lists;
import com.javaman.webprojectlearn.myjson.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyStream {
    public static void main(String[] args) {
        String a="1";
        String b="1";
        System.out.println(a==b);
       // List<Integer> list = Arrays.asList(1, 2, null, 11, 2, null, 55, null, 32, 33, 67, null, 8);
       /* Student s1=new Student();
        s1.setId(1);
        Student s2=new Student();
        s1.setId(2);
        Student s3=new Student();
        s1.setId(3);
        Student s4=new Student();
        s1.setId(4);
        Student s5=new Student();
        s1.setId(5);
        List<Student> list=new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);list.add(s4);
        list.add(s5);
        list=list.stream().peek(o-> {
            o.setId(100);
        }).collect(Collectors.toList());
        System.out.println(list);
        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        System.out.println(nums);
        System.out.println(nums.stream().filter(num -> num != null).distinct().
                mapToInt(numn -> numn * 2).peek(System.out::print).skip(2).limit(4).sum());*/
      /*  List<Integer> nnn=  nums.stream().filter(nn->nn!=null).filter(numss ->{
            if (numss >=2){
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        System.out.println(nnn);*/



        /*Stream<Integer> stream=Stream.of(1,2,3,4,5);
        List<Integer> list= (List<Integer>) stream;
        System.out.println(list);*/

       /* List<Integer> list=new ArrayList<>();
        Stream<Integer> stream=list.stream();//获取顺序流
        Stream<Integer> parallelStream=list.parallelStream();//获取并行流

        Integer[] integers=new Integer[5];
        Stream<Integer> stream1=Arrays.stream(integers);*/



    }

}
