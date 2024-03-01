package com.javaman.webprojectlearn.mycollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list = Arrays.asList("h", "e", "l", "p");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
