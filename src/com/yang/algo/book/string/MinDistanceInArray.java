package com.yang.algo.book.string;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

/**
 * @ClassName MinDistanceInArray
 * @Description Give a Array of String and two String named str1, str2
 * return min distance of str1 to str2 in the given array.
 * @Author YangC
 * @Date 2019/7/17 9:49
 **/
public class MinDistanceInArray {
    public int minDistance(String[] strs, String str1, String str2){
        if (strs == null || strs.length == 0){
            return -1;
        }
        if (str1 == null || str2 == null){
            return -1;
        }
        if (str1.equals(str2)){
            return 0;
        }
        int lastStr1 = -1;
        int lastStr2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i != strs.length; i ++){
            if (strs[i].equals(str1)){
                min = Math.min(min, lastStr2 == -1 ? min : i - lastStr2);
                lastStr1 = i;
            }
            if (strs[i].equals(str2)){
                min = Math.min(min, lastStr1 == -1 ? min : i - lastStr1);
                lastStr2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
