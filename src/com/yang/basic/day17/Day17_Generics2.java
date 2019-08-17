package com.yang.basic.day17;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Iterator<E> iterator
 * */

public class Day17_Generics2 {
    public static void main(String[] args) {
     //创建集合对象
        Collection c = new ArrayList();//多态，父类的引用指向子类的对象

     //boolean add(E e)
        System.out.println(c.add("hello"));
        System.out.println(c.add("world"));

     //void clear();清空集合
        c.clear();

    //boolean contains(Object o) 判断集合中是否含有指定元素
        System.out.println(c.contains("java"));

    //boolean isEmpty 判断集合是否为空
        System.out.println(c.isEmpty());

        System.out.println(c);
    }
}
