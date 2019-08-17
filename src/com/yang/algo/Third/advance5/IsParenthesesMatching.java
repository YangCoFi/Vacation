package com.yang.algo.Third.advance5;

import java.util.Stack;

/**
 * @ClassName IsParenthesesMatching
 * @Description TODO
 * @Author YangC
 * @Date 2019/7/22 13:28
 **/
public class IsParenthesesMatching {
    public static boolean isMatches(String expresstion){
        char[] chas = expresstion.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chas.length; i ++){
            if (chas[i] == '{' || chas[i] == '[' || chas[i] == '('){
                stack.add(chas[i]);
            }
            if (chas[i] == '}' || chas[i] == ']' || chas[i] == ')'){
                char toMatch = chas[i] == '}' ? '{' : (chas[i] == ']' ? '[' : '(');
                if (stack.isEmpty() || !stack.pop().equals(toMatch)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "{1+(2+3)+[(1+3)+(4*5)]}";
        String test2 = "{1+(2+3)+(1+3)+(4*5)]}";
        System.out.print(isMatches(test1) + " " + isMatches(test2));
    }
}
