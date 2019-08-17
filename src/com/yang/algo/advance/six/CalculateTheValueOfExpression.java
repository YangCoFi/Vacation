package com.yang.algo.advance.six;

import java.util.LinkedList;

public class CalculateTheValueOfExpression {

    private static int getValue(String str) {
        return value(str.toCharArray(),0)[0];
    }

    /**
     * @Parm str: char[]数组，永远不变
     * @Parm i: 从当前i开始
     * 返回值：int[] 长度一定为2 需要两个信息 arr[0]代表计算结果,arr[1]代表算到了哪个位置
     * */
    private static int[] value(char[] c, int i) {
        LinkedList<String> queue = new LinkedList<>();      //收集
        int pre = 0;                                //用于收集数字，遇到符号停止
        int[] result = null;
        while (i < c.length && c[i] != ')'){        //进到while里面的必然不是右括号和数组末尾
            if (c[i] >= '0' && c[i] <= '9'){        //遇到的一直是数字
                pre = pre * 10 + c[i ++] - '0';     //减去0的ASCII值就是个位上的数
            }else if (c[i] != 'c'){                 //遇到了加减乘除
                //将遇到的数字和符号都收集到栈里去
                addNum(queue, pre);
                queue.addLast(String.valueOf(c[i ++]));     //将指定元素插入此双端队列的末尾
                pre = 0;
            }else {                                 //当前i位置是左括号，从i+1位置开始，进递归，得出与左括号配对的右括号里面的表达式计算出来返回
                result = value(c, i + 1);
                pre = result[0];
                i = result[1] + 1;
            }
        }
        addNum(queue, pre);
        return new int[]{getNum(queue), i};
    }

    private static int getNum(LinkedList<String> queue) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!queue.isEmpty()){
            cur = queue.pollFirst();
            if (cur.equals("+")){
                add = true;
            }else if (cur.equals("-")){
                add = false;
            }else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    private static void addNum(LinkedList<String> queue, int num) {
        if (!queue.isEmpty()){
            int cur = 0;
            String top = queue.pollLast();
            if (top.equals("+") || top.equals("-")){
                queue.addLast(top);
            }else {
                cur = Integer.valueOf(queue.pollLast());
                num = top.equals("*") ? (num * cur) : (cur / num);
            }
        }
        queue.addLast(String.valueOf(num));
    }

    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getValue(exp));
    }
}
