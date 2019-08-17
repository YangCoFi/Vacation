package com.yang.algo.leetcode;


import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 *
 * Some examples:
 *
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * @author YangCoFi
 * @Date 2019/07/06
 * */
public class EvaluateReversePolishNotation {

//    public static int getNum(String[] token){
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < token.length; i ++){
//            try {
//                int num = Integer.parseInt(token[i]);
//                stack.push(num);
//            }catch (Exception e){
//                int num1 = stack.pop();
//                int num2 = stack.pop();
//                stack.push(evaluateNum(num1, num2, token[i]));
//            }
//        }
//        return stack.pop();
//    }
//
//    public static int evaluateNum(int num1, int num2, String operator){
//        switch (operator){
//            case "+":
//                return num1 + num2;
//            case "-":
//                return num2 / num1;
//            case "*":
//                return num1 * num2;
//            case "/":
//                return num2 / num1;
//            default:
//                return 0;
//        }
//    }

    public int evalRPN(String[] tokens){
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i ++){
            String cur = tokens[i];
            if (cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")){
                if (stack.size() < 2){
                    return 0;
                }
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (cur.equals("+")){
                    stack.push(num1 + num2);
                }
                if (cur.equals("-")){
                    stack.push(num2 - num1);
                }
                if (cur.equals("*")){
                    stack.push(num1 * num2);
                }
                if (cur.equals("/")){
                    stack.push(num2 / num1);
                }
            }else {
                try {
                    int num = Integer.parseInt(cur);
                    stack.push(num);
                }catch (NumberFormatException e){
                    return 0;
                }
            }
        }
        return stack.size() == 1 ? stack.pop() : 0;
    }

}
