package com.yang.algo.HuaWei;
import java.util.Scanner;

/**
 * @ClassName CountTheNumberOfUppercaseLetters
 * @Description 找出给定字符串中大写字符(即'A'-'Z')的个数
 * @Author YangC
 * @Date 2019/8/23 21:23
 **/
public class CountTheNumberOfUppercaseLetters{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        System.out.println(CalcCapital(in));
    }

    private static int CalcCapital(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i ++){
            if (chars[i] >= 'A' && chars[i] <= 'Z'){
                result ++;
            }
        }
        return result;
    }
}
