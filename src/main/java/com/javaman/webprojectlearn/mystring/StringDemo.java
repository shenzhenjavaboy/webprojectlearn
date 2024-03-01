package com.javaman.webprojectlearn.mystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringDemo {
    public static void main(String[] args) {
     /*   String str="abcdefg";
        String str1="你好啊世界";
        String a=str.substring(str.length()-4);
        String b=str1.substring(str1.length()-4);
        String c=str.substring(0,str.length()-4);
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);*/


        List<String> list = Arrays.asList("深圳股份有限公司", "长沙股份有限公司", "东莞有限责任公司", "肇庆有限责任公司",
                "岳阳有限公司", "武汉有限公司", "guangzhouLImited","beijingLIMITED");
        List<String> list1 = new ArrayList<>();
        String name = null;

        for (String str:list) {
            str=str.replaceAll("(?i)limited","");
            list1.add(str);
        }

        for (String listname : list) {

            listname = listname.replaceAll("股份有限公司", "");
            listname = listname.replaceAll("有限公司", "");
            listname = listname.replaceAll("有限责任公司", "");
            //英文公司尾称带limited或者LiMiTed等 去掉   方法一
            if (listname.length() >= 7) {
                if (listname.substring(listname.length() - 7).toUpperCase().equals("LIMITED")) {
                    listname = listname.substring(0, listname.length() - 7);
                }
            }
            //方法二  用正则匹配
            if (listname.length() >= 7) {
                if (listname.substring(listname.length() - 7).matches("[Ll][Ii][Mm][Ii][Tt][Ee][Dd]")) {
                    listname = listname.substring(0, listname.length() - 7);
                }
            }
            //方法三   用equalsIgnoreCase方法 直接忽略掉大小写
            if (listname.length() >= 7) {
                if (listname.substring(listname.length() - 7).equalsIgnoreCase("limited")) {
                    listname = listname.substring(0, listname.length() - 7);
                }
            }

            list1.add(listname);
        }


        System.out.println(list1);
    }
}
