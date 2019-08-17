package com.yang.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int run1(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        //因为如果一个子树如果左右孩子只有其中一个有的话，必须选择有值的那个孩子，否则就不是最短路径了
        if(root.left == null || root.right == null){
            return Math.max(run1(root.left),run1(root.right)) + 1;
        }
        return Math.min(run1(root.left),run1(root.right)) + 1;
    }

    public static int run2(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            depth ++;
            for (int i = 0; i < len; i ++){
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null){
                    //说明我已经到了叶节点了
                    return depth;
                }
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
        }
        return 0;
    }
}