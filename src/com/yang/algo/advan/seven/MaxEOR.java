package com.yang.algo.advan.seven;

public class MaxEOR {

    //暴力解
    public static int getMaxE1(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i ++){
            for (int start = 0; start <= i; start ++){
                int res = 0;
                for (int j = start; j <= i; j ++){
                    res ^= arr[j];
                }
                max = Math.max(max, res);
            }
        }
        return max;
    }

    public static int getMaxE2(int[] arr){
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];     //记录结果
        int eor = 0;
        for (int i = 0; i < arr.length; i ++){
            eor ^= arr[i];  //0...i的异或结果
            max = Math.max(eor,max);
            for (int start = 1; start <= i; start ++){
                int curEor = eor ^ dp[start - 1];
                max = Math.max(max, curEor);
            }
            dp[i] = eor;
        }
        return max;
    }
}
