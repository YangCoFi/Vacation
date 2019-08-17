package com.yang.algo.advan.seven;
/**
 * @ClassName CardGameProblem
 * @Description TODO
 * @Author YangC
 * @Date 2019/7/11 15:42
 **/
public class CardGameProblem {
    //暴力递归
    public static int maxScoreOfWinner(int[] arr){
       if (arr == null){
           return 0;
       }
       return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    private static int f(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex == endIndex){
            return arr[beginIndex];
        }
        return Math.max(arr[beginIndex] + s(arr, beginIndex + 1, endIndex),
                arr[endIndex] + s(arr, beginIndex, endIndex - 1));
    }

    private static int s(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex == endIndex){
            return 0;
        }
        return Math.min(f(arr, beginIndex + 1, endIndex),
                f(arr, beginIndex, endIndex - 1));          //先拿者A绝顶聪明，拿完后会让B拿的时候最小
    }


    //DP版本
    public static int maxScoreOfWinnerDp(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];       //横纵坐标分别相当于递归版本的beginIndex和endIndex
        int[][] s = new int[arr.length][arr.length];
        //不被依赖的位置，对角线上的位置先填好
        for (int i = 0; i < arr.length; i ++){
            for (int j = 0; j <arr.length; j ++ ){
                if (i == j){
                    f[i][j] = arr[i];
                }
            }
        }
        //状态依赖
        for (int i = 1; i < arr.length; i ++){
            for (int row = 0; row < arr.length - i; row ++){
                int col = row + i;
                f[row][col] = Math.max(arr[row] + s[row + 1][col], arr[col] + s[row][col - 1]);
                s[row][col] = Math.min(f[row + 1][col], f[row][col - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 100, 4, 29, 27, 45, 92, 273, 36, 32, 266, 231, 435, 32423, 234};
        long startTime1 = System.currentTimeMillis();
        int temp1 = maxScoreOfWinner(arr);
        long endTime1 = System.currentTimeMillis();
        System.out.println(temp1 + "--->运行时间:" + (endTime1 - startTime1) + "ms");

        long startTime2 = System.currentTimeMillis();
        int temp2 = maxScoreOfWinnerDp(arr);
        long endTime2 = System.currentTimeMillis();
        System.out.println(temp2 + "--->运行时间:" + (endTime2 - startTime2) + "ms");
    }
}
