package com.yang.algo.alpha;

/**
 * @ClassName SalaryGiven
 * @Description TODO
 * @Author YangC
 * @Date 2019/9/6 16:29
 **/
public class SalaryGiven {
    public static int salary(int month){
        if (month <= 0){
            return 0;
        }
        if (month == 1){
            return 3;
        }
        if (month == 2){
            return (int) (Math.pow(3, month) - 1);
        }
        return (int) (Math.pow(3, month) - calC(month) - calB(month));
    }

    public static int calC(int month){
        int sum = 0;
        for (int i = 2; i < month; i ++){
            sum = sum + amount(month, i);
        }
        return sum;
    }

    public static int calB(int month){
        int sum = 0;
        for (int i = 3; i < month; i ++){
            sum = sum + (month - i + 1);
        }
        return sum;
    }

    //排列Cab
    public static int amount( int a,int b) {
        int big = 1;
        int small = 1;
        for(int i = 0; i < b; i ++) {
            big = big * a;
            a --;
        }
        for(; b > 0; b --) {
            small = small * b;
        }
        return big / small;
    }

    public static void main(String[] args) {
        int month = 5;
        System.out.println(salary(month));
    }

}
