package com.javaman.webprojectlearn.myio;


import java.io.*;
import java.util.Arrays;

public class IoDemo {

    public static void main(String[] args) throws IOException {
//        File file=new File("D://a.txt");
//        OutputStream os = new FileOutputStream(file,true);
//        String s="hallo";
//        os.write(s.getBytes());
//        os.flush();
//        os.close();
        //写的操作，如果不存在某个文件  则会创建
       /* FileOutputStream fos=new FileOutputStream("a.txt",true);
        String hello="hello bank of pingan\r\n";
        for (int i = 0; i < 9; i++) {
            fos.write(hello.getBytes());

        }
        fos.flush();
        fos.close();
*/

        //输入流 读的操作，如果文件名不存在  则会报错
        InputStream in = new FileInputStream("a.txt");

        int a = 0;
        byte[] bytes = new byte[3];

        //每读一次 指针就会走到下一个字符   当没有字符的时候 读出来的值就是-1.
//        int len = in.read();//返回的是每个字节的ascII码值
//        int len1=in.read(bytes);//返回的是数组的长度,如果文本内容字节大于数组长度，返回的是数组长度，如果文本内容小于字节长度，返回的
        //是文本内容字节的长度
        //method1
    /*    while ((a = in.read(bytes)) != -1) {//这个时候就给byte数组的元素赋值了
            System.out.println(new String(bytes));//用new String（bytes)给读出来的数据转换成string类型
        }

        //method2
        while ((a = in.read()) != -1) {
            System.out.println(new String(bytes));
            System.out.print((char) a);//将ASCII转换成字符
        }*/

        //method3
        while((a= in.read(bytes))!=-1){
            System.out.println(new String(bytes,0,a));
            System.out.println(a);
        }

    }
}
