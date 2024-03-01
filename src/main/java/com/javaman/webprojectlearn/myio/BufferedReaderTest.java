package com.javaman.webprojectlearn.myio;

import java.io.*;
import java.util.stream.Stream;

public class BufferedReaderTest {

    public static void main(String[] args) throws FileNotFoundException {

        InputStreamReader inputStream= new FileReader("D:/a.txt");
        BufferedReader br = new BufferedReader(inputStream);
        Stream<String> stringStream=br.lines();
        System.out.println(stringStream);

        stringStream.forEach(line->{

            System.out.println("*******");
            System.out.println(line);


        });
    }
}
