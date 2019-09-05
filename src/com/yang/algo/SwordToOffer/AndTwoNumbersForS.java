package com.yang.algo.SwordToOffer;

import java.util.ArrayList;

/**
 * @ClassName AndTwoNumbersForS
 * @Description 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @Author YangC
 * @Date 2019/8/31 14:56
 **/
public class AndTwoNumbersForS {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (right > left){
            if (array[left] + array[right] > sum){
                right --;
            }else if (array[left] + array[right] < sum){
                left ++;
            }else {
                list.add(array[left]);
                list.add(array[right]);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,15};
        int sum = 15;
        System.out.println(FindNumbersWithSum(array, 15));

    }
}
