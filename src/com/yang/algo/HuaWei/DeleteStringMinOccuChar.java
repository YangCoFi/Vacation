package com.yang.algo.HuaWei;

import sun.swing.PrintingStatus;

import java.util.Scanner;

/**
 * @ClassName DeleteStringMinOccuChar
 * @Description 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
    输入描述:
    字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
    输出描述:
    删除字符串中出现次数最少的字符后的字符串。
 * @Author YangC
 * @Date 2019/8/31 11:40
 **/
public class DeleteStringMinOccuChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(dispose(s));
    }

    public static String dispose(String s){
        int min = Integer.MAX_VALUE;
        int[] str = new int[26];
        for (int i = 0; i < s.length(); i ++){
            str[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i ++){
            if (str[s.charAt(i) - 'a'] <= min){
                min = str[s.charAt(i) - 'a'];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++){
            if (str[s.charAt(i) - 'a'] != min){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
