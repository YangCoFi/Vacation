package com.yang.basic.day17;

import java.util.LinkedList;

/*
 * List的常用子类：
 * 		ArrayList
 * 			底层是数组结构，查询快，增删慢
 * 		LinkedList
 * 			底层结构是链表，查询慢，增删快
 *
 * 如何选择使用不同的集合？
 * 		如果查询多，增删少，则使用ArrayList
 * 		如果查询少，增删多，则使用LinkedList
 * 		如果你不知道使用什么，则使用ArrayList
 *
 * LinkedList的特有功能：
 * 			void addFirst(E e)
 * 			void addLast(E e)
 			E getFirst()
 			E getLast()
 			E removeFirst()
 			E removeLast()
 *
 */
public class Day_17_Generics9 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("hello");
        list.add("world");

        //void addFirst(E e)  :将元素添加到索引为0的位置
        //void addLast(E e) ：将元素添加到索引为size()-1的位置
        list.addFirst("java");
        list.addLast("android");

        //E getFirst()  :获取索引为0的元素
        //E getLast()  ：获取索引为size()-1的元素
        //System.out.println(list.getFirst());
        //System.out.println(list.getLast());

        //E removeFirst() :删除索引为0的元素并返回
        //E removeLast() ：删除索引为size()-1的元素并返回
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());


        System.out.println(list);
    }
}
