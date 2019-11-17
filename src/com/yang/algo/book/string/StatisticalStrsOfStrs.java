package com.yang.algo.book.string;

/**
 * @ClassName StatisticalStrsOfStrs
 * @Description Give String “aaabbadddffc”
 * return a_3_b_2_a_1_d_3_f_2_c_1
 * @Author YangC
 * @Date 2019/10/6 21:17
 **/
public class StatisticalStrsOfStrs {
    public String getCountString(String str){
        if (str == null || str.length() == 0){
            return "";
        }
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(chs[0]));
        int num = 1;
        for (int i = 1; i < chs.length; i ++){
            if (chs[i] != chs[i - 1]){
                sb.append("_" + String.valueOf(num) + (String.valueOf(chs[i]).equals("") ? String.valueOf(chs[i]) : "_" + String.valueOf(chs[i])));
                num = 1;
            }else {
                num ++;
            }
        }
        return sb.append("_" + String.valueOf(num)).toString();
    }

    public static void main(String[] args) {
        System.out.println(new StatisticalStrsOfStrs().getCountString("aaabbadddffc"));
    }
}
