package com.yang.algo.HuaWei;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @ClassName PasswordVerificationProcedure
 * @Description 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 * @Author YangC
 * @Date 2019/8/29 8:50
 **/
public class PasswordVerificationProcedure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String temp = sc.nextLine();
            System.out.println(isPassed(temp));
        }
    }

    public static String isPassed(String password){
        if (password == null || password.length() < 9){
            return "NG";
        }
        char[] chars = password.toCharArray();
        int[] judge = new int[4];
        for (int i = 0; i < chars.length; i ++){
            if (chars[i] >= '0' && chars[i] <= '9'){
                judge[0] = 1;
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z'){
                judge[1] = 1;
            }
            if (chars[i] >= 'a' && chars[i] <= 'z'){
                judge[2] = 1;
            }else {
                judge[3] = 1;
            }
        }
        if (judge[0] + judge[1] + judge[2] + judge[3] < 3){
            return "NG";
        }else {
            return isSameSubString(password);
        }

    }

    private static String isSameSubString(String password) {
        for (int i = 0; i < password.length() - 3; i ++){
            String s1 = password.substring(i, i + 3);
            String s2 = password.substring(i + 3);
            if (s2.contains(s1)){
                return "NG";
            }
        }
        return "OK";
    }
}


//Pattern构造器是私有的，可知不能通过new创建Pattern对象。
//通过Pattern调用静态方法compile返回Pattern实例。