package com.yang.algo.SwordToOffer;

/**
 * @ClassName FirstCharacterAppearsOnlyOnce
 * @Description 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @Author YangC
 * @Date 2019/8/29 18:30
 **/
public class FirstCharacterAppearsOnlyOnce {

    public static void main(String[] args) {
        String a = "deepdarkfantasy";
        System.out.println(FirstNotRepeatingChar(a));
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        int[] arr = new int[256];
        for (int i = 0; i < arr.length; i ++){
            arr[i] = -1;
        }
        for (int i = 0; i < str.length(); i ++){
            int asci = str.charAt(i);
            if (arr[asci] == -1){
                arr[asci] = i;
            }else if (arr[asci] >= 0){
                arr[asci] = -2;
            }
        }
        for (int i = 0; i < str.length(); i ++){
            int asci = str.charAt(i);
            if (arr[asci] >= 0){
                return arr[asci];
            }
        }
        return -1;
    }
}
