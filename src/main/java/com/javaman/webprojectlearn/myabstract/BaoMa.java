package com.javaman.webprojectlearn.myabstract;

public class BaoMa extends MyAbstract{
    @Override
    public String Car(String carname) {
        return "i'm "+carname;
    }

    public static void main(String[] args) {

        MyAbstract myAbstract=new BaoMa();
        System.out.println(myAbstract.Car("baoma"));
    }
}
