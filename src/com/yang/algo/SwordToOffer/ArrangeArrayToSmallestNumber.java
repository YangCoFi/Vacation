package com.yang.algo.SwordToOffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName ArrangeArrayToSmallestNumber
 * @Description 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * @Author YangC
 * @Date 2019/8/24 13:57
 **/
public class ArrangeArrayToSmallestNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString() + o2.toString();
                String s2 = o2.toString() + o1.toString();
                return Integer.parseInt(s1) - Integer.parseInt(s2);
            }
        });
        StringBuilder res = new StringBuilder();
        for (Integer integer : list){
            res.append(integer.toString());
        }
        return res.toString();
    }
}


//很明显valueof返回的是Integer对象,函数里面其实也是调用parseInt函数。到这里我们就知道了，valueof就是把parseInt返回值封装成对象。在FIndBugs时可能会提醒你，能用parseInt就不用valueof，parseInt效率更高。
/**
 *         Arrays.sort(numbers, new Comparator<Integer>() {
 *             @Override
 *             public int compare(Integer o1, Integer o2) {
 *                 return 0;
 *             }
 *
 *             报错！！！
 *
 * 在使用泛型时注意：任何基本类都不能作为类型参数。虽然从Java SE 5.0开始使用了自动包装机制，包装机制解决了一些问题，但不是所有问题都能解决。
 * 自动包装机制不能用于数组，因此无法工作。
 *
 * https://blog.csdn.net/s10461/article/details/53941091    泛型
 * */