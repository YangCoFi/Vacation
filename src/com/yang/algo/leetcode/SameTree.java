package com.yang.algo.leetcode;

/**
 * @ClassName SameTree
 * @Description Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @Author YangC
 * @Date 2019/9/28 15:34
 **/
public class SameTree {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }


    //首先判断两个树是否为空，如果同时为空，返回true，一个为空另一个不为空，返回false
    //再判断两个树对应节点的值是否相等，
    //写个递归，分别同时判断两个树的左子树节点和右子树节点
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        boolean isSame = p.val == q.val;
        return isSame && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
