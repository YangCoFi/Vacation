package com.yang.algo.leetcode;
import java.util.Arrays;

/**
 * @ClassName LongestConsecutiveSequence
 * @Description Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * Your algorithm should run in O(n) complexity.
 * @Author YangC
 * @Date 2019/9/26 20:53
 **/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0){
            return 0;
        }
        Arrays.sort(num);

        int length = 0;
        int cur = 1;
        for(int i = 1; i < num.length; i ++){
            if(num[i] == num[i - 1]){
                continue;
            }
            if(num[i] - num[i - 1] == 1){
                cur ++;
            }else{
                if(cur > length){
                    length = cur;
                }
                cur = 1;
            }
        }
        if(cur > length){
            length = cur;
        }
        return length;
    }
}