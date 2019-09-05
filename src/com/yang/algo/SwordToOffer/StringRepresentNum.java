package com.yang.algo.SwordToOffer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName StringRepresentNum
 * @Description 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"  "-.123"  都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @Author YangC
 * @Date 2019/9/5 11:36
 **/
public class StringRepresentNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(isNumeric(str.toCharArray()));
        }
    }

    public static Boolean isNumeric(char[] str) {
        String pattern = "[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?";
//        Pattern r = Pattern.compile(pattern);
//        Matcher matcher = r.matcher(String.valueOf(str));
        return Pattern.matches(pattern, String.valueOf(str));
    }
}




/**
 * 上面提到，一个正则表达式可以有多个分组，例如：
 * (John) (.+?)
 * 这个表达式匹配文本”John” 后跟一个空格,然后跟1个或多个字符，最后跟一个空格。你可能看不到最后的空格。
 * 这个表达式包括一些字符有特别意义。字符 点 . 表示任意字符。 字符 + 表示出现一个或多个，和. 在一起表示 任何字符,出现一次或多次。字符? 表示 匹配尽可能短的文本。
 * 完整代码如下
 * String text    =
 *           "John writes about this, and John Doe writes about that," +
 *                   " and John Wayne writes about everything."
 *         ;
 * String patternString1 = "(John) (.+?) ";
 * Pattern pattern = Pattern.compile(patternString1);
 * Matcher matcher = pattern.matcher(text);
 * while(matcher.find()) {
 *     System.out.println("found: " + matcher.group(1) +
 *                        " "       + matcher.group(2));
 * }
 * 注意代码中引用分组的方式。代码输出如下
 * 1
 * 2
 * 3
 * found: John writes
 * found: John Doe
 * found: John Wayne
 *
 * */