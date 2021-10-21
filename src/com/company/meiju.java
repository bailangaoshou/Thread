package com.company;


public  enum meiju {

    Red(1) ,Green(2),Bule(3),Null;

    //这三个都是meiju类的对象！

    //这些枚举对象都只能定义在枚举类型内部



   //有意思的是，这些对象只能由自己来初始化,如Red(1),执行meiju(int value)方法，将Red对象的value置为1

    private int value;
    private meiju(){

    }
    private meiju(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;

    }

}
