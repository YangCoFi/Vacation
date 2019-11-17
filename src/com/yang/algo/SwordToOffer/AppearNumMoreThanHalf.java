package com.yang.algo.SwordToOffer;

/**
 * @ClassName AppearNumMoreThanHalf
 * @Description 数组中出现次数超过一半的数
 * @Author YangC
 * @Date 2019/10/11 17:48
 **/
public class AppearNumMoreThanHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        //利用随机快排的思想，找到中位数。再判断该中位数是否是出现次数超过一半的数。
        if (array == null || array.length == 0){
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        int index = partition(array,0 , array.length - 1);
        int half = array.length >> 1;
        while (index != half){
            index = index > half ? partition(array, 0, index - 1) : partition(array, index + 1, array.length - 1);
        }
        int count = 0;
        for (int i = 0; i < array.length; i ++){
            count = (array[i] == count) ? ++ count : count;
        }
        return (count > array.length / 2) ? array[index] : 0;
    }

    private int partition(int[] array, int L, int R) {
        if (array == null || array.length == 0 || L < 0 || R > array.length - 1 || L > R){
            throw new IllegalArgumentException();
        }
        if (L == R){
            return R;
        }
        int num = (int) (L + Math.random() * (R - L + 1));
        swap(array, num, R);
        int less = L - 1;
        for (int i = L; i < R; i ++){
            if (array[i] < array[R]){
                swap(array, ++ less, i);
            }
        }
        swap(array, ++ less, R);
        return less;
    }

    private void swap(int[] array, int L, int R) {
        array[L] = array[L] ^ array[R];
        array[R] = array[L] ^ array[R];
        array[L] = array[L] ^ array[R];
    }
}
