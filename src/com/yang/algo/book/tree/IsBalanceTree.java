package com.yang.algo.book.tree;

/**
 * @ClassName IsBalanceTree
 * @Description TODO
 * @Author YangC
 * @Date 2019/8/24 11:09
 **/
public class IsBalanceTree {

    public static class TreeNode{
        int val;
        TreeNode left ;
        TreeNode right ;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean isB(TreeNode head){
        return process(head).isB;
    }

    public static class ReturnType{
        boolean isB;
        int height;

        public ReturnType(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }

    private static ReturnType process(TreeNode head) {
        if (head == null){
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(head.left);
        if (!leftData.isB){
            return new ReturnType(false, 0);    //是false了都不用走右子树 直接返回给父节点
        }
        ReturnType rightData = process(head.right);
        if (!rightData.isB){
            return new ReturnType(false, 0);
        }
        if (Math.abs(leftData.height - rightData.height) > 1){
            return new ReturnType(false, 0);
        }
        return new ReturnType(true, Math.max(leftData.height, rightData.height) + 1);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.left.left.left = new TreeNode(6);
        System.out.println(isB(head));
    }
}
