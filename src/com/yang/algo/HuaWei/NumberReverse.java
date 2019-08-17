package com.yang.algo.HuaWei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName NumberReverse
 * @Description 输入一个整数，将这个整数以字符串形式逆序输出。程序不考虑负数的情况，若数字含有0，则
 * 逆序形式也含有0，如输入为100，则输出为001
 * @Author YangC
 * @Date 2019/7/22 17:49
 **/
public class NumberReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            String res = numReverse2String(num);
            System.out.println(res);
        }
    }
    public static String numReverse2String(int num){
        char[] chars = String.valueOf(num).toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i ++){
            stack.push(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(String.valueOf(stack.pop()));
        }
        return sb.toString();
    }
}
