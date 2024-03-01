package com.javaman.webprojectlearn;

import com.javaman.webprojectlearn.lambda.*;
import com.javaman.webprojectlearn.pojo.Person;
import org.springframework.data.relational.core.sql.In;

import java.util.*;

public class   LambdaDemo {
    public enum direction{
        FRONT,BEHIND,LEFT,RIGHT;
    }

    public static void main(String[] args) {
         //测试lambda
        /*():  是用来描述参数列表
        {}:  是用来描述方法体
        ->:  lambda运算法  读作goes to*/

         //1、无参数无返回值
        NoneReturnNoneParameter demo1=()->{
            System.out.println("hallo1");
        };
        demo1.test();

        //语法精简==============方法体中只有一条语句时  可以省略大括号
        NoneReturnNoneParameter demo11=()-> System.out.println("hallo11");
        demo11.test();

        //2、无返回值单个参数
        NoneReturnSingleParameter demo2=(int a)->{
            System.out.println("hallo2");
        };
        demo2.test(1);

        //语法精简==============参数的类型只有一个时，可以省略小括号 和参数类型
        NoneReturnSingleParameter demo22=a -> System.out.println("hallo22");
        demo22.test(1);


        //3、无返回值多个参数
        NoneReturnManyParameter demo3=(int a,String b)->{
            System.out.println("hallo3");
        };
        demo3.test(1, "3");

        //语法精简==============参数的类型要么都省略，要么都不省略
        NoneReturnManyParameter demo33=(a,b)-> System.out.println("hallo33");
        demo33.test(1,"2");

        //4、有返回值无参数
        SingleReturnNoneParameter demo4=()->{
            System.out.println("hallo4");
            return 1;
        };
        demo4.test();
        //语法精简====================如果返回体是方法里的唯一语句时，可以省略return,注意：花括号也要省略
        SingleReturnNoneParameter demo44=()->1;
        demo44.test();

        //5、有返回值有单个参数
        SingleReturnSingleParameter demo5=(int a)->{
            System.out.println("hallo5");
            return a;
        };
        demo5.test(1);

        //语法精简
        SingleReturnSingleParameter demo55=a -> a;
        demo55.test(3);
        //6、有返回值有多个参数
        SingleReturnManyParameter demo6=(int a,String b)->{
            System.out.println("hallo6");
            return a;
        };
        demo6.test(1,"2");

        //方法引用
            /*可以快速的将lambda表达式的实现指向一个已经实现的方法
              语法： 方法的隶属者::方法名
                注意：
                静态方法： 类名::方法名
                非静态方法: 对象名:方法名*/

        //7、方法引用----第一种
        SingleReturnSingleParameter demo7=a -> change(a);//
        System.out.println(demo7.test(2));

        //7、方法引用----第二种
        SingleReturnSingleParameter demo77=LambdaDemo::change;//静态方法 类名::方法名
        System.out.println(demo77.test(2));

        //8、构造方法引用-----无参
        LambdaPerson1 person1=()->new Person();
        LambdaPerson1 person2=Person::new;
        System.out.println(person2.getPerson());

        //8、构造方法引用-----有参
        LambdaPerson2 person3=Person::new;
        Person personn = person3.getPerson2(1, "chenpeng");
        System.out.println(personn);

        //9、集合排序
        ArrayList<Person> list=new ArrayList<>();
        list.add(new Person(1,"zhangsan"));
        list.add(new Person(2,"lisi"));
        list.add(new Person(3,"wangwu"));


        list.sort(((o1, o2) -> o2.getId()-o1.getId()));
        System.out.println(list);

        //删除集合中id大于2的元素
        ListIterator<Person> it=list.listIterator();
        while (it.hasNext()){
            Person per=it.next();
            if (per.getId()>=2){
                it.remove();
            }
        }
        //删除集合中id大于2的元素 ----lambda表达式
       
        System.out.println(list);

        //10、遍历
        ArrayList<Integer> list1=new ArrayList<>();
        Collections.addAll(list1,1,2,3,4,5,6);
        list1.forEach(ele->{
           // System.out.println(ele);
            if (ele%2==0){
                System.out.println(ele);
            }
        });


    }
    public static int change(int a){
        return 2*a;
    }
}
