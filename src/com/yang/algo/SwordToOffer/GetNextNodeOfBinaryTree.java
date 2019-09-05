package com.yang.algo.SwordToOffer;

/**
 * @ClassName GetNextNodeOfBinaryTree
 * @Description TODO
 * @Author YangC
 * @Date 2019/8/24 13:26
 **/
public class GetNextNodeOfBinaryTree {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null){
            return null;
        }
        if (pNode.right != null){
            TreeLinkNode p = pNode.right;
            while (p.left != null){
                p = p.left;
            }
            return p;
        }else {
            TreeLinkNode p = pNode.next;
            while (pNode != p.left){
                pNode = p;
                p = p.next;
            }
            return p;
        }
    }
}
