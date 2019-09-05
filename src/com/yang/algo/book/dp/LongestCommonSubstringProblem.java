package com.yang.algo.book.dp;

import javax.sound.midi.SoundbankResource;

/**
 * @ClassName LongestCommonSubstringProblem
 * @Description 给定两个字符串str1和str2，返回两个字符串的最长公共子串
 * @Author YangC
 * @Date 2019/8/18 20:29
 **/
public class LongestCommonSubstringProblem {
    //生成dp矩阵
    //dp[i][j]表示在把str[i]和str[j]当作最后一个字符的情况下，最长公共子串的长度。
    public static int[][] getDp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i ++){
            dp[i][0] = str1[i] == str2[0] ? 1 : 0;
        }
        for (int j = 1; j < str2.length; j ++){
            dp[0][j] = str1[0] == str2[j] ? 1 : 0;
        }
        for (int i = 1; i < str1.length; i ++){
            for (int j = 1; j < str2.length; j ++){
                dp[i][j] = str1[i] == str2[j] ? dp[i - 1][j - 1] + 1 : 0;
            }
        }
        return dp;
    }

    //遍历dp，找最大值
    public static String LongestCommonString(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
            return "";
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = getDp(ch1, ch2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i ++){
            for (int j = 0; j < dp[0].length; j ++){
                if (dp[i][j] > max){
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(LongestCommonString("abcdefg", "master"));
    }
}
