package com.yang.algo.SwordToOffer;

import java.util.Stack;

/**
 * @ClassName StackContainingMinFunction
 * @Description 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * @Author YangC
 * @Date 2019/8/24 21:36
 **/
public class StackContainingMinFunction {
    private static Stack<Integer> dataStack;
    private static Stack<Integer> minStack;
    static {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int node) {
        dataStack.push(node);
        if (!minStack.isEmpty() && minStack.peek() < node){
            minStack.push(minStack.peek());
        }else {
            minStack.push(node);
        }
    }

    public void pop() {
        if (!dataStack.isEmpty()){
            dataStack.pop();
            minStack.pop();
        }else {
            throw new IllegalArgumentException("Stack is empty!");
        }
    }

    public int top() {
        if (!dataStack.isEmpty()){
            return dataStack.peek();
        }else {
            throw new IllegalArgumentException("Stack is empty!");
        }

    }

    public int min() {
        if (!dataStack.isEmpty()){
            return minStack.peek();
        }else {
            throw new IllegalArgumentException("Stack is empty!");
        }
    }
}
