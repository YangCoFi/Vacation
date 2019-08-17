package com.yang.algo.HuaWei;

/**
 * @ClassName StringSplit
 * @Description TODO
 * @Author YangC
 * @Date 2019/7/12 12:56
 **/
public class StringSplit {
    public static void main(String[] args) {
        String s = "adasdsadsdasd123";
        while(s.length()>=8){
            System.out.println(s.substring(0, 8));
            s=s.substring(8);
        }
    }
}
