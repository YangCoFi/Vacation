package com.yang.algo.HuaWei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName StringConnectionLongestPathLookup
 * @Description 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出：数据输出n行，输出结果为按照字典序排列的字符串。
 * @Author YangC
 * @Date 2019/8/4 21:51
 **/

//TreeSet不能存放重复的数据，测试数据可能含有重复数据
public class StringConnectionLongestPathLookup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] strings = new String[num];
        for (int i = 0; i < num; i ++){
            strings[i] = scanner.next();
        }
        Arrays.sort(strings);
        for (int i = 0; i < strings.length; i ++){
            System.out.println(strings[i]);
        }
    }
}
