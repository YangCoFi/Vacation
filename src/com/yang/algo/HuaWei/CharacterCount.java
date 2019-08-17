package com.yang.algo.HuaWei;

import java.lang.annotation.Target;
import java.util.Scanner;

/**
 * @ClassName CharacterCount
 * @Description 编写一个函数，计算字符串中含有的不同字符的个数。
 * 字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 * @Author YangC
 * @Date 2019/7/31 16:49
 **/

//System.in作为字节输入流类InputStream的对象实现标准输入，通过read(）方法从键盘接受数据。
public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            int len = getLen(s);
            System.out.println(len);
        }
    }

    private static int getLen(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i ++){
            arr[s.charAt(i)] = 1;
        }
        int len = 0;
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] == 1){
                len ++;
            }
        }
        return len;
    }
}
