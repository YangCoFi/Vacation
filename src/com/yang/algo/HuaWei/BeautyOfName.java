package com.yang.algo.HuaWei;

/**
 * @ClassName BeautyOfName
 * @Description Given a name, the name consists of 26 chars, and the "prettyness" that defines the string is the sum of all the letters "beauty".
 *  Each letter has a "beauty" that ranges from 1 to 26. No two letters have the same "beauty". The letters are case insensitive.
 *  Given multiple names, calculate the maximum possible "prettyness" for each name.
 * @Author YangC
 * @Date 2019/8/17 9:52
 **/

/**
 * .InputStream、OutputStream
 * 处理字节流的抽象类
 * InputStream 是字节输入流的所有类的超类,一般我们使用它的子类,如FileInputStream等.
 * OutputStream是字节输出流的所有类的超类,一般我们使用它的子类,如FileOutputStream等.
 *
 * 2.InputStreamReader  OutputStreamWriter
 * 处理字符流的抽象类
 * InputStreamReader 是字节流通向字符流的桥梁,它将字节流转换为字符流.
 * OutputStreamWriter是字符流通向字节流的桥梁，它将字符流转换为字节流.
 *
 * 3.BufferedReader BufferedWriter
 * BufferedReader 由Reader类扩展而来，提供通用的缓冲方式文本读取，readLine读取一个文本行，
 * 从字符输入流中读取文本，缓冲各个字符，从而提供字符、数组和行的高效读取。
 * BufferedWriter  由Writer 类扩展而来，提供通用的缓冲方式文本写入， newLine使用平台自己的行分隔符，
 * 将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
 *
 * InputStream能从來源处读取一個一個byte,
 * 所以它是最低级的，
 * */

import java.util.Scanner;
import java.util.Arrays;
public class BeautyOfName{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            String[] str = new String[n];
            for(int i = 0; i < n; i ++){
                str[i] = sc.next();
            }
            for(int i = 0; i < str.length; i ++){
                System.out.println(calculateBeauty(str[i]));
            }
        }

    }

    public static int calculateBeauty(String str){
        char[] ch = str.toCharArray();
        int[] target = new int[26];
        for(int i = 0; i < ch.length; i ++){
            target[ch[i] - 'a'] ++;
        }
        Arrays.sort(target);
        int res = 0;
        for(int i = target.length - 1; i >= 0; i --){
            res += target[i] * (i + 1);
        }
        return res;
    }
}



/**
 *
 * 首先对于输入的数据，在计算机中实际表示是这样的，包含三个空格和一个换行符：
 * aaa bbb ccc \n
 * netx()函数从遇到的第一个有效的字符a开始扫描，直到遇到第一个空格扫描结束，得到字符串”aaa”
 * nextLine()函数从空格开始扫描知直到遇到\n符结束，故得到字符串是 ” bbb ccc”，注意这里bbb前面还有一个空格
 * 所以如果要同时使用next和nextLine()时，要慎用，因为联合使用时就是一个整体，next在前，nextLine靠后，扫描接受的是同一行上的字符串，只不过接收的是不同内容罢了。
 *
 *
 * nextInt()读取一个键盘获取的数字之后焦点并不会移动到下一行，这时候如果下面语句中跟了一句nextLine()的话就读不到输入的内容了。因为nextLine()是遇到换行符结束读取，nextInt()读取的内容还没有换行，所以紧跟着nextInt()的nextLine()就只是读取到了最后的换行符。在nextInt()后面用next()读取的话是可以得，也有点小文题是，next()遇到空格会结束。所以后面split那里不能根据空格进行拆分。即输入时不能用空格来分隔一行中输入的内容。
 *
 *
 *
 * */