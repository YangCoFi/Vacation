package com.yang.algo.leetcode;

import java.util.Stack;

/**
 * @ClassName lLargestRectangleInHistogram
 * @Description TODO
 * @Author YangC
 * @Date 2019/10/7 20:32
 **/
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        //利用单调栈
        int maxArea = height[0];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i ++){
            while(!stack.isEmpty() && height[i] < height[stack.peek()]){
                int index = stack.pop();
                int leftBorder = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height[index] * (i - leftBorder - 1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            int rightBorder = height.length;
            int leftBorder = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, height[index] * (rightBorder - leftBorder - 1));
        }
        return maxArea;
    }
}
