package com.yang.algo.SwordToOffer;

import java.util.zip.Checksum;

/**
 * @ClassName KthNodeInBinaTree
 * @Description TODO
 * @Author YangC
 * @Date 2019/9/11 20:43
 **/
public class KthNodeInBinaTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null){
            return null;
        }
        TreeNode res = null;
        int sum = k;
        inOrder(pRoot, sum, res);
        return res;
    }

    private void inOrder(TreeNode pRoot, int sum, TreeNode res) {
        if (pRoot == null){
            return;
        }
        inOrder(pRoot.left, sum, res);
        sum --;
        if (sum == 0){
            res = pRoot;
            return;
        }
        inOrder(pRoot.right, sum, res);
    }
}


/**
 * 方法调用时，实际参数把它的值传递给对应的形式参数，函数接收的是原始值的一个copy，此时内存中存在两个相等的基本类型，即实际参数和形式参数，后面方法中的操作都是对形参这个值的修改，不影响实际参数的值。
 * 引用传递：
 * 也称为传地址。方法调用时，实际参数的引用(地址，而不是参数的值)被传递给方法中相对应的形式参数，函数接收的是原始值的内存地址；
 * 在方法执行中，形参和实参内容相同，指向同一块内存地址，方法执行中对引用的操作将会影响到实际对象。*/