package com.company;


import java.util.ArrayList;

public class demo {

    public static void main(String[] args) {

//        Class c1 = new ArrayList<String>().getClass();
//
//        Class c2 = new ArrayList<Integer>().getClass();
//
//        System.out.println(c1 == c2); // true


        //由于类型擦除的存在，泛型不同的对象编译后相等！！！


        meiju meiju = com.company.meiju.Null;

        System.out.println(meiju.getValue());



    }

}