package com.yang.basic.day17;
import java.util.ArrayList;
/**
 * ArrayList遍历
 * */

//字符串length()方法
//数组是length属性
//集合是size()方法

// *  ArrayList
//         *  集合的体系结构：
//         *  	由于不同的数据结构（数据的组织，存储方式），所以Java为我们提供了不同的集合，
//         *  	但是不同的集合他们的功能都是相似，不断的向上提取，将共性抽取出来，这就是集合体系结构形成的原因
//         *  体系结构：
//         *  		怎么学习?最顶层开始学习，因为最顶层包含了所有的共性
//         *  		怎么使用？使用最底层，因为最底层就是具体的实现

//List特点：有序，允许重复，而且有索引
public class Day17_Generics1 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList al = new ArrayList();
        //添加元素
        al.add("hello");
        al.add("world");
        al.add("java");
        //遍历集合 这里用for循环进行遍历
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }
}
