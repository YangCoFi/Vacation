package com.yang.algo.SwordToOffer;

import sun.reflect.generics.tree.Tree;

import javax.sound.midi.SoundbankResource;

/**
 * @ClassName DepthOfBinaryTree
 * @Description 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @Author YangC
 * @Date 2019/8/30 16:00
 **/
public class DepthOfBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        System.out.println(TreeDepth(root));
    }
}
