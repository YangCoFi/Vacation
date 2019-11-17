package com.yang.algo.HuaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @ClassName StringSort
 * @Description 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *        如，输入： Type   输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *      如，输入： BabA   输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *      如，输入： By?e   输出： Be?y
 * 样例：
 *     输入：
 *    A Famous Saying: Much Ado About Nothing(2012/8).
 *     输出：
 *    A  aaAAbc   dFgghh :  iimM   nNn   oooos   Sttuuuy  (2012/8).
 * @Author YangC
 * @Date 2019/9/26 18:38
 **/
public class StringSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null){
            List<Character> list = new ArrayList<>();
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length; i ++){
                if (Character.isLetter(c[i])){
                    list.add(c[i]);
                }
            }
            Collections.sort(list, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }
            });
            int letterCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i ++){
                if (Character.isLetter(c[i]) && letterCount < list.size()){
                    sb.append(list.get(letterCount));
                    letterCount ++;
                }else {
                    sb.append(c[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }
}


/**
* 1.对ArrayList和LinkedList而言，在列表末尾增加一个元素所花的开销都是固定的。对 ArrayList而言，主要是在内部数组中增加一项，指向所添加的元素，偶尔可能会导致对数组重新进行分配；而对LinkedList而言，这个开销是 统一的，分配一个内部Entry对象。
2.在ArrayList集合中添加或者删除一个元素时，当前的列表所所有的元素都会被移动。而LinkedList集合中添加或者删除一个元素的开销是固定的。
3.LinkedList集合不支持 高效的随机随机访问（RandomAccess），因为可能产生二次项的行为。
4.ArrayList的空间浪费主要体现在在list列表的结尾预留一定的容量空间，而LinkedList的空间花费则体现在它的每一个元素都需要消耗相当的空间
**/