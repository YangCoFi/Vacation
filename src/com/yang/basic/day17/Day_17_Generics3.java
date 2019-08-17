package com.yang.basic.day17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Day_17_Generics3 {
    /*
     * 集合的遍历方式：
     * 		1.toArray(),可以把集合转换成数组，然后遍历数组即可
     * 		2.iterator(),可以返回一个迭代器对象，我们可以通过迭代器对象来迭代集合
     *
     * Iterator：可以用于遍历集合
     * 	E next()  :返回下一个元素
     *  boolean hasNext()  ：判断是否有元素可以获取
     *
     *  注意：Exception in thread "main" java.util.NoSuchElementException
     *  	使用next方法获取下一个元素，如果没有元素可以获取，则出现NoSuchElementException

     */

    public static void main(String[] args) {
        //method();
        //创建集合对象
        Collection c = new ArrayList();
        //添加元素
        c.add("hello");
        c.add("world");
        c.add("java");

        //获取迭代器对象
        Iterator it = c.iterator();

        //Object next()  :返回下一个元素
        //boolean hasNext()  ：判断是否有元素可以获取

    /*if(it.hasNext())
        System.out.println(it.next());
    if(it.hasNext())
        System.out.println(it.next());
    if(it.hasNext())
        System.out.println(it.next());
    if(it.hasNext())
        System.out.println(it.next());*/

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void method() {
        //创建集合对象
        Collection c = new ArrayList();
        //添加元素
        c.add("hello");
        c.add("world");
        c.add("java");
        //获取数组
        Object[] objs = c.toArray();
        //遍历数组
        for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i]);
        }
    }
}


