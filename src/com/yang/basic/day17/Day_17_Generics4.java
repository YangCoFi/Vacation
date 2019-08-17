package com.yang.basic.day17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class Day_17_Generics4 {
    /*
     * 需求：判断集合中是否包含元素java，如果有则添加元素android
     * Exception in thread "main" java.util.ConcurrentModificationException:并发修改异常
     * 迭代器是依赖于集合的，相当于集合的一个副本，当迭代器在操作的时候，如果发现和集合不一样(比如说元素个数不一样)，则抛出异常
     *
     * 解决方案:
     * 		你就别使用迭代器
     * 		在使用迭代器进行遍历的时候使用迭代器来进行修改。在用迭代器进行遍历的时候，如果我们用集合本身去改，就不一样了。
     */
        public static void main(String[] args) {
            //method();

            //创建集合对象
            //Collection c = new ArrayList();
            List c = new ArrayList();
            //添加元素
            c.add("hello");
            c.add("world");
            c.add("java");

            //我们可以通过遍历来获取集合中的每一个元素，然后进行比较即可
		/*Iterator it = c.iterator();
		while(it.hasNext()) {
			String s = (String)it.next();
			if(s.equals("java")) {
				c.add("android");
			}
		}*/

            ListIterator lit = c.listIterator();
            while(lit.hasNext()) {
                String s = (String)lit.next();
                if(s.equals("java")) {
                    lit.add("android");     //迭代器去添加，他就会去同步集合
                }
            }
            System.out.println(c);
        }

        private static void method() {
            //创建集合对象
            Collection c = new ArrayList();
            //添加元素
            c.add("hello");
            c.add("world");
            c.add("java");
            //判断集合中是否包含元素java
            if(c.contains("java")) {
                c.add("android");
            }
            System.out.println(c);
        }

    }
