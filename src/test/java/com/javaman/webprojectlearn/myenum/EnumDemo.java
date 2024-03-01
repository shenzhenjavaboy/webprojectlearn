package com.javaman.webprojectlearn.myenum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumDemo {
    @Test
    public void fun1(){
        List<String> list=new ArrayList<>();
      //  list = Arrays.asList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY");
        Day[] days=Day.values();
        for (Day day:days) {
            switch (day){
                case MONDAY:
                    list.add("MONDAY");
                    break;
                case TUESDAY:
                    list.add("TUESDAY");
                    break;
                case WEDNESDAY:
                    list.add("WEDNESDAY");
                    break;
                case THURSDAY:
                    list.add("THURSDAY");
                    break;
                case FRIDAY:
                    list.add("FRIDAY");
                    break;
                case SATURDAY:
                    list.add("SATURDAY");
                    break;
                case SUNDAY:
                    list.add("SUNDAY");
            }

        }
        System.out.println(list);

    }
}
