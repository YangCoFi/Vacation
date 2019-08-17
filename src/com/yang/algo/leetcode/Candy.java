package com.yang.algo.leetcode;

import java.util.Arrays;

/**
 * @ClassName Candy
 * @Description There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * @Author YangC
 * @Date 2019/7/16 10:16
 **/

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0 || ratings == null){
            return 0;
        }
        int n = ratings.length;
        int[] candyArray = new int[n];
        Arrays.fill(candyArray, 1);
        for (int i = 1; i < candyArray.length; i ++){
            if (ratings[i] > ratings[i - 1]){
                candyArray[i] = candyArray[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int i = candyArray.length - 1; i > 0; i --){
            if (ratings[i - 1] > ratings[i] && candyArray[i] >= candyArray[i - 1]){
                candyArray[i - 1] = candyArray[i] + 1;
            }
            sum += candyArray[i];
        }
        sum += candyArray[0];
        return sum;
    }
}
