package com.yang.algo.leetcode;

/**
 * @ClassName UniquePaths
 * @Description A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 * @Author YangC
 * @Date 2019/11/17 10:05
 **/
public class UniquePaths {
    //recursion
    public int uniquePathsRecu(int m, int n) {
        if (m == 0 || n == 0){
            return 0;
        }
        if (m == 1 || n == 1){
            return 1;
        }
        return uniquePathsRecu(m - 1, n) + uniquePathsRecu(m, n - 1);
    }

    //dp 矩阵中元素意义：从开始到这个位置的走法数
    public int uniquePathsRecuDp(int m, int n){
        int[][] dp = new int[m][n];
        // 首先 第一行和第一列的元素值都是1(只可能往右走或者往下走)
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                }else {
                    // 对于一个普遍位置而言，它的值是上面的元素值加上左边的元素值
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePathsRecuDp(3,5));
    }
}
