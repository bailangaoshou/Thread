package com.company;

public class fanxing {
    //T E K V 均代表泛型
    //List<?>代表任何泛型List的父类
    //<? extends E> 类型通配符上限

    //<? super E>类型通配符下限

//    当我们尝试add一个Apple的时候，flist可能指向new ArrayList<Orange>();
//    当我们尝试add一个Orange的时候，flist可能指向new ArrayList<Apple>();
//    当我们尝试add一个Fruit的时候，这个Fruit可以是任何类型的Fruit，而flist可能只想某种特定类型的Fruit，编译器无法识别所以会报错。
//    所以对于实现了<? extends T>的集合类只能将它视为Producer向外提供(get)元素，而不能作为Consumer来对外获取(add)元素。
//    如果我们要add元素应该怎么做呢？可以使用<? super T>：

    //一句话概括，要想往里放，必须保证List是待放对象的父类列表。
    //要想往外拿，必须保证List是暂存对象的子对象。


    public <E extends Number> void test( E element){

        Number n = element;

        System.out.println(n.floatValue());

    }

    public static void main(String[] args) {
        new fanxing().<Integer>test(5);
    }
}

class  wtf <E>{
    private  E e ;

    public  void  show(E element){

    }

}
