package com.yang.algo.advan.seven;

/**
 * @ClassName RobotWalkingProblem
 * @Description Given N position, which index are 1,2,3,......,N. The robot stay at M at first,
 * after walking P steps, it stops at K, so how many times about it wakling?
 * @Author YangC
 * @Date 2019/7/16 20:45
 **/
public class RobotWalkingProblem {
    //暴力递归
    public static int process(int N, int M, int P, int K){
        if (P == 0)
            return M == K ? 1 : 0;
        if (M == 1) {
            return process(N, M + 1, P - 1, K);
        }else if (M == N){
            return process(N, M - 1, P - 1, K);
        }
        return process(N, M + 1, P - 1, K) + process(N, M - 1, P - 1, K);
    }

    //DP
    //暴力递归可以看到变化的参数是M和P
    //一张表，P从0到P表示剩余步数，M从1到N表示当前到来的位置
    //杨辉三角形
    public static int processDp(int N, int M, int P, int K){
        int[][] dp = new int[N + 1][P + 1];
        dp[K][0] = 1;
        for (int j = 1; j <= P; j ++){
            for (int i = 1; i <= N; i ++){
                if (i - 1 < 1){
                    dp[i][j] = dp[i + 1][j - 1];
                }else if (i + 1 > N){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = dp[i + 1][j - 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[M][P];
    }
    public static void main(String[] args) {
        long startTime1 = System.currentTimeMillis();
        int temp1 = process(30, 5, 30, 7);
        long endTime1 = System.currentTimeMillis();
        System.out.println(temp1 + "--->运行时间:" + (endTime1 - startTime1) + "ms");

        long startTime2 = System.currentTimeMillis();
        int temp2 = processDp(9000, 321, 4000, 330);
        long endTime2 = System.currentTimeMillis();
        System.out.println(temp2 + "--->运行时间:" + (endTime2 - startTime2) + "ms");
    }
}
