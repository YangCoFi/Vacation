package com.yang.algo.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree{1,#,2,3},
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * return[1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 * */

public class BinaryTreePreOrderTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
        return list;
    }
}
