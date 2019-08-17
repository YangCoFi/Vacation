package com.yang.basic.day17;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 使用集合存储自定义对象并遍历
 * 由于集合可以存储任意类型的对象，当我们存储了不同类型的对象，就有可能在转换的时候出现类型转换异常，
 * 所以java为了解决这个问题，给我们提供了一种机制，叫做泛型
 * 把明确数据类型的工作提前到了编译时期，借鉴了数组的特点，类型不一样，不让你通过
 * 避免了类型转换的问题
 *  * 什么时候可以使用泛型？
 * 		问API，当我们看到<E>，就可以使用泛型了
 * *
 */
public class Day_17_Generics5 {



    public static void main(String[] args) {
        //创建集合对象
        Collection  c = new ArrayList();
        //创建元素对象
        Student s = new Student("zhangsan",18);
        Student s2 = new Student("lisi",19);
        //添加元素对象
        c.add(s);
        c.add(s2);
        //遍历集合对象

        Iterator  it = c.iterator();
        while(it.hasNext()) {
            String str = (String)it.next();
            System.out.println(str);
        }
    }
}
    class Student {
    String name;
    int age;

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }
}


