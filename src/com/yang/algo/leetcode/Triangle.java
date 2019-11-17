package com.yang.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Triangle
 * @Description Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [↵     [2],↵    [3,4],↵   [6,5,7],↵  [4,1,8,3]↵]↵
 *
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * @Author YangC
 * @Date 2019/9/26 10:09
 **/
public class Triangle {
//    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//
//    }

//    //method one:Recurrence of violence
//    private static int dfs(ArrayList<ArrayList<Integer>> trangleI, int row, int col){
//        if (row >= trangleI.size()){
//            return 0;
//        }
//        int val = trangleI.get(row).get(col);
//        return val + Math.min(dfs(trangleI, row + 1, col), dfs(trangleI, row + 1, col + 1));
//    }

    //method two:Dp
    private static int dp(ArrayList<ArrayList<Integer>> trangleI){
        int size = trangleI.size();
        int dp[][] = new int[size][size];
        // 填好最后一行
        for (int i = 0; i < size; i ++){
            dp[size - 1][i] = trangleI.get(size - 1).get(i);
        }
        for (int i = size - 2; i >= 0; i --){
            for (int j = 0; j < i + 1; j ++){
                dp[i][j] = trangleI.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> testTriangle = new ArrayList<ArrayList<Integer>>();
        testTriangle.add(new ArrayList<Integer>(Arrays.asList(2)));
        testTriangle.add(new ArrayList<Integer>(Arrays.asList(3,4)));
        testTriangle.add(new ArrayList<Integer>(Arrays.asList(5,6,7)));
        testTriangle.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
        System.out.println(dp(testTriangle));
    }
}


//https://www.cnblogs.com/interdrp/p/8045750.html