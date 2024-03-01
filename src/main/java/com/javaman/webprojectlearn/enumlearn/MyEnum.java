package com.javaman.webprojectlearn.enumlearn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MyEnum {
    public static void main(String[] args) {


        ArrayList<Integer> integers=new ArrayList<>();
        integers.add(1);
        integers.add(20);
        integers.add(3);
        integers.add(22);

      /*  Iterator<Integer> it=integers.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/
        for (Integer i:integers
             ) {
            System.out.println(i);

        }
        Color color=Color.RED;
        Day day=Day.TUESDAY;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入...");
        int i=sc.nextInt();

        switch (i){
            case 1:i=i++;
                System.out.println(i);
                break;
            case 2:i=i+2;
                System.out.println(i);
                break;
            case 3:i=i+3;
                System.out.println(i);
                break;
            default:
                System.out.println("sha ye bu shi ");


        }

        System.out.println(color);
        switch (day){
            case MONDAY:
                System.out.println("1");
                break;
            case TUESDAY:
                System.out.println("2");
                break;
            case THURSDAY:
                System.out.println("3");
                break;
            case WEDNESDAY:
                System.out.println("4");
                break;
            case FRIDAY:
                System.out.println("5");
                break;
            case SATURDAY:
                System.out.println("6");
                break;
            case SUNDAY:
                System.out.println("7");
                break;
            default:
                System.out.println("输入的日期有误，请重新输入...");
        }

    }

}
enum Color{
    RED,BLUE,BLACK,YELLOW,ORANGE,GREEN,WHITE
}
 enum Day{
     MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}
