package com.javaman.webprojectlearn.myio;

import java.util.Arrays;

public class testArraystoString {
    public static void main(String[] args) {
        int[] a={1,2,3,2,33,4,88,9};
        System.out.println(Arrays.toString(a));

        long[] b={11,22,33,44};
        System.out.println(Arrays.toString(b));

        double[] c = {1.1, 2.2, 3.3, 4.4};
        System.out.println(Arrays.toString(c));

        String[] str={"aa","bb","cc"};
        System.out.println(Arrays.toString(str));

        int n=11;
        System.out.println((char)n);

       /* byte[] bytes={47,48,49,4};

        String string="hallo";
        System.out.println(new String(bytes,0,3));*/
    }
}
