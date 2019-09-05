package com.yang.algo.HuaWei;
import java.util.Scanner;

/**
 * @ClassName NumReverse
 * @Description 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * @Author YangC
 * @Date 2019/9/5 14:47
 **/
public class NumReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            String str = String.valueOf(num);
            System.out.println(new StringBuilder(str).reverse().toString());
        }
    }
}
