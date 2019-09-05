package com.yang.algo.HuaWei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName ExtractNonRepeatingIntegers
 * @Description 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * E.g.
 * Input:9876673
 * Output:37689
 * @Author YangC
 * @Date 2019/8/22 21:15
 **/
public class ExtractNonRepeatingIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] c = String.valueOf(scanner.nextInt()).toCharArray();
        List<Character> list = new LinkedList<>();
        for (int i = c.length - 1; i >= 0; i --){
            if (!list.contains(c[i])){
                list.add(c[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!list.isEmpty()){
            stringBuilder.append(((LinkedList<Character>) list).removeFirst());
        }
        System.out.println(Integer.valueOf(stringBuilder.toString()));
    }
}
