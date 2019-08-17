package com.yang.basic.day17;

import java.util.ArrayList;
import java.util.List;
/*
 * List:
 * 		有序的（存储和读取的顺序是一致的）
 * 		有整数索引
 * 		允许重复的
 *
 * List的特有功能：
 * 			void add(int index, E element)
 * 			E get(int index)
 * 			E remove(int index)
 *  		E set(int index, E element)
 *
 *   增删改查
 */
public class Day_17_Generics8 {
    public static void main(String[] args) {
        //创建的列表对象
        List list = new ArrayList();

        //void add(int index, E element)  : 在指定索引位置添加指定元素
        list.add(0, "hello");
        list.add(0, "world");
        list.add(1, "java");

        //E get(int index)  :根据索引返回元素
		/*System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));*/
        //System.out.println(list.get(3));

		/*for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/

        //E remove(int index)  : 删除指定元素并返回

        //System.out.println(list.remove(5));

        //E set(int index, E element) : 将指定索引位置的元素替换为指定元素，并将原先的元素返回
        System.out.println(list.set(0, "android"));

        System.out.println(list);
    }
}
