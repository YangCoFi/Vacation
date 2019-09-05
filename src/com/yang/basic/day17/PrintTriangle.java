package com.yang.basic.day17;

import java.util.Scanner;

/**
 * @ClassName printTriangle
 * @Description TODO
 * @Author YangC
 * @Date 2019/8/28 20:27
 **/
public class PrintTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i ++){
            for (int j = 0; j < rows - i; j ++){
                System.out.print(" ");
            }
            for (int k = 0; k < i; k ++){
                System.out.print(" 1");
            }
            System.out.println();
        }
    }
}
