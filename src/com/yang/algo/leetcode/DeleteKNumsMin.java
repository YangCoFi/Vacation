package com.yang.algo.leetcode;

/**
 * @ClassName DeleteKNumsMin
 * @Description TODO
 * @Author YangC
 * @Date 2019/10/27 20:23
 **/
public class DeleteKNumsMin {
    public static String removeDigits(String num, int k){
        String newNum = num;
        for (int i = 0; i < k; i ++){
            boolean hasCut = false;
            for (int j = 0; j < newNum.length() - 1; j ++){
                if (newNum.charAt(j) > newNum.charAt(j + 1)){
                    newNum = newNum.substring(0, j) + newNum.substring(j + 1, newNum.length());
                    hasCut = true;
                    break;
                }
            }
            if (! hasCut){
                newNum = num.substring(0, num.length() - 1);
            }
            newNum = removeZero(newNum);
        }
        if (newNum.length() == 0){
            return "0";
        }
        return newNum;
    }

    private static String removeZero(String newNum) {
        for (int i = 0; i < newNum.length(); i ++){
            if (newNum.charAt(0) != '0'){
                break;
            }
            newNum = newNum.substring(1, newNum.length());
        }
        return newNum;
    }

    public static void main(String[] args) {
        System.out.println(removeDigits("14564564", 3));
    }
}
