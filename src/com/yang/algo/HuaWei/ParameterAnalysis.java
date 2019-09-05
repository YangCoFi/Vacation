package com.yang.algo.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName ParameterAnalysis
 * @Description 在命令行输入如下命令：
 * xcopy /s c:\ d:\，
 * 各个参数如下：
 * 参数1：命令字xcopy
 * 参数2：字符串/s
 * 参数3：字符串c:\
 * 参数4: 字符串d:\
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 *
 * 解析规则：
 * 1.参数分隔符为空格
 * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s “C:\program files” “d:\”时，参数仍然是4个，第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 *
 * 示例1
 * 输入
 *  xcopy /s c:\\ d:\\
 *
 * 输出
 * 4
 * xcopy
 * /s
 * c:\\
 * d:\\
 *
 * @Author YangC
 * @Date 2019/8/22 21:57
 **/
public class ParameterAnalysis {
    /**
     * 通过java.util.regex包下的Pattern类与Matcher类实现
     * Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,它的构造方法是私有的,不可以直接创建,但可以通过Pattern.complie(String regex)简单工厂方法创建一个正则表达式
     * */

    /**
     * Pattern p=Pattern.compile("\\w+");
     * p.pattern();//返回 \w+
     * pattern() 返回正则表达式的字符串形式,其实就是返回Pattern.complile(String regex)的regex参数
     * */
    public static void main(String ... args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            // 为了正则分组，后面加一个空格
            String line = sc.nextLine() + " ";
            // 1、先看是不是被“”包起来，用非贪婪形正则匹配到第一个反引号出现的位置，中间的部分都算进去
            // 2、再考虑没有引号可能会出现的情况：数字、字母、反斜线正斜线和冒号
            // 3、最后使用正则环视看后面是不是有空格，有空格则进行抽出来
            Pattern p = Pattern.compile("((“.+?”)|[a-zA-Z0-9/\\\\:]+)(?= )");
            Matcher matcher = p.matcher(line);
            int count = 0;
            List<String> res = new ArrayList<>();
            while(matcher.find()){
                count++;
                res.add(matcher.group().replaceAll("“|”", ""));
            }
            System.out.println(count);
            res.stream().forEach(System.out::println);
        }
    }

}



/**
 * this is text
 匹配字符串 "this is text"
 this\s+is\s+text
 注意字符串中的 \s+。
 匹配单词 "this" 后面的 \s+ 可以匹配多个空格，之后匹配 is 字符串，再之后 \s+ 匹配多个空格然后再跟上 text 字符串。
 可以匹配这个实例：this is text
 ^\d+(\.\d+)?
 ^ 定义了以什么开始
 \d+ 匹配一个或多个数字
 ? 设置括号内的选项是可选的
 \. 匹配 "."
 可以匹配的实例："5", "1.5" 和 "2.21"。
 *
 *
 * */