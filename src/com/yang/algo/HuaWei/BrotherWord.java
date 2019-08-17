package com.yang.algo.HuaWei;

import javax.sound.midi.SoundbankResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @ClassName BrotherWord
 * @Description 输入描述:
 * 先输入字典中单词的个数n，再输入n个单词作为字典单词。
 * 再输入一个单词，查找其在字典中兄弟单词的个数m
 *
 * 再输入数字k
 *
 * 输出描述:
 * 根据输入，输出查找到的兄弟单词的个数m
 * 然后输出查找到的兄弟单词的第k个单词。
 * @Author YangC
 * @Date 2019/8/1 16:50
 **/
public class BrotherWord {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = bufferedReader.readLine()) != null){
            String[] s = input.split(" ");
            int n = Integer.valueOf(s[0]);
            int k = Integer.valueOf(s[s.length - 1]);
            String str = s[s.length - 2];
            int m = 0;
            String[] ss = new String[n];
            if (n >= 0 && n <= 1000){
                for (int i = 1; i < s.length - 1; i ++){
                    if (s[i].length() >= 1 && s[i].length() <= 50){
                        if (isBrother(str, s[i])){
                            ss[m ++] = s[i];
                        }
                    }else {
                        System.out.println("单词长度越界");
                        System.exit(0);
                    }
                }
            }else{
                System.out.println("n越界");
                System.exit(0);
            }
            System.out.println(m);
            if (k < m){
                sort(ss, k);
            }
        }
    }

    private static void sort(String[] ss, int k) {
        int min = 0;
        for (int i = 0; i < ss.length; i ++){
            min = i;
            for (int j = i + 1; j < ss.length; j ++){
                if (ss[i] != null && ss[j] != null){
                    if (ss[j].compareTo(ss[min]) < 0){
                        min = j;
                    }
                }
            }
            String temp = ss[min];
            ss[min] = ss[i];
            ss[i] = temp;
        }
        System.out.println(ss[k - 1]);
    }

    private static boolean isBrother(String str, String s) {
        int[] s1 = new int[26];
        for (int i = 0; i < str.length(); i ++){
            s1[(int)str.charAt(i) - 97] ++;
        }
        int[] s2 = new int[26];
        for (int i = 0; i < s.length(); i ++){
            s2[(int)s.charAt(i) - 97] ++;
        }
        if (str.length() == s.length() && !str.equals(s)){
            for (int i = 0; i < 26; i ++){
                if (s1[i] == s2[i]){
                }else {
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}
