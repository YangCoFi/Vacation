package com.yang.algo.HuaWei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ClassName EnterNIntegersOutputSmallestK
 * @Description 输入n个整数，输出其中最小的k个。
 * @Author YangC
 * @Date 2019/8/23 21:46
 **/
public class EnterNIntegersOutputSmallestK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null){
            int n = Integer.parseInt(str.split(" ")[0]);
            int k = Integer.parseInt(str.split(" ")[1]);
            String line = br.readLine();
            String[] strs = line.split(" ");
            int[] nums = new int[strs.length];
            for (int i = 0; i < strs.length; i ++){
                nums[i] = Integer.valueOf(strs[i]);
            }
            Arrays.sort(nums);
            String res = Arrays.toString(Arrays.copyOf(nums,k));
            System.out.println(res.substring(1, res.length() - 1).replace("," ,""));
        }
    }
}


/**
 *
 * System.out.println(array);这样是不行的，这样打印是的是数组的首地址。*/