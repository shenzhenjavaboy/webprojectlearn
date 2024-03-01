package com.javaman.webprojectlearn.myio;

import java.io.*;
import java.util.Arrays;

public class IoDemoTwo {
    public static void main(String[] args) throws IOException {
        //需求：将D盘文件a.txt的内容拷贝到D盘文件b.txt上去

        //第一步先读取a.txt的内容  D盘---->内存  输入流


        OutputStream os=new FileOutputStream("D://a.txt");
        InputStream is = new FileInputStream("D://a.txt");
        byte[] bytes = new byte[1024];
        int len=0;
        OutputStream osp=new FileOutputStream("D://b.txt");
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
            if (len ==bytes.length){
                os.write(bytes);
            }
            else {
                byte[] bytes1= Arrays.copyOfRange(bytes,0,len);//截取部分长度
                os.write(bytes1);
            }
        }
    }
}
