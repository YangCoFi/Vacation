package com.yang.algo.Third.advance5;

/**
 * @ClassName CardWangYiGame
 * @Description 给你一组牌，希望让你选的牌加在一起值是一个给定的值，同时在这个条件的限制下，怎么乘最大
 * Example: 1 2 3 4 5    10         5*3*2最大 30
 * (全是正数)
 * @Author YangC
 * @Date 2019/7/22 14:31
 **/
public class CardWangYiGame {
    //变形的背包问题

    //主函数
    public static int getMax(int[] arr, int sum){
        return process(arr, 0, sum);
    }

    //递归含义process:从index位置开始，包括index位置上的纸牌以及后面所有的纸牌你自由选择，保证加起来的和是sum，在这种情况下返回最大的乘积
    public static int process(int[] arr, int index, int sum){
        //base case  如果不合法，立刻返回一个无效值
        if (sum < 0){
            return -1;
        }
        if (index == arr.length){
            return sum == 0 ? 1 : -1;
        }
        //彻底不考虑当前index位置上的数
        int notIncludeCurIndex = process(arr, index + 1, sum);
        //使用当前的数
        int useCurIndex = arr[index] * process(arr, index + 1, sum - arr[index]);
        return Math.max(notIncludeCurIndex, useCurIndex);
    }

    //可变参数是两个，所以2维表
    public static int maxGivenMultiply(int[] arr, int threshold){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[][] dp = new int[arr.length][threshold + 1];
        if (arr[0] <= threshold){
            dp[0][arr[0]] = arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= threshold; j++) {
                int no = dp[i - 1][j];
                int only = j - arr[i] == 0 ? arr[i] : 0;
                int part = j - arr[i] > 0 ? dp[i - 1][j - arr[i]] * arr[i] : 0;
                dp[i][j] = Math.max(no, Math.max(only, part));
            }
        }
         printMatrix(dp); // 可以打印dp看看
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] generateArray(int len, int max){
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i ++){
            arr[i] = (int) (Math.random()*max);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = generateArray(30, 10);

        long startTime1 = System.currentTimeMillis();
        int temp1 = getMax(arr, 50);
        long endTime1 = System.currentTimeMillis();
        System.out.println(temp1 + "--->运行时间:" + (endTime1 - startTime1) + "ms");

        long startTime2 = System.currentTimeMillis();
        int temp2 = maxGivenMultiply(arr, 50);
        long endTime2 = System.currentTimeMillis();
        System.out.println(temp2 + "--->运行时间:" + (endTime2 - startTime2) + "ms");
    }
}
