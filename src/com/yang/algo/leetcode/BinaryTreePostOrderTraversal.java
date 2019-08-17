package com.yang.algo.leetcode;

import javafx.scene.transform.Shear;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * return[3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 * */

public class BinaryTreePostOrderTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

//    public ArrayList<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        if (root == null){
//            return arrayList;
//        }
//        completeList(root, arrayList);
//        return arrayList;
//    }

//    public static void completeList(TreeNode node, ArrayList<Integer> arrayList){
//        if (node.left != null){
//            completeList(node.left, arrayList);
//        }
//        if (node.right != null){
//            completeList(node.right, arrayList);
//        }
//        arrayList.add(node.val);
//    }

    //非递归
    //左不为空先压左，右不为空后压右
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            root = s1.pop();
            if (root.left != null){
                s1.push(root.left);
            }
            if (root.right != null){
                s1.push(root.right);
            }
            s2.push(root);
        }
        while (!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);

        ArrayList<Integer> list = postorderTraversal(head);
        System.out.println(list.toString());
    }
}


/**
 * 　　实际上，将list转化为array的时候，第二种重构方法更方便，用法如下：
 *
 * String[] array =new String[list.size()];
 * list.toArray(array);
 *    List<Object> object = getSession().createSQLQuery(sql).list();
 *     Set<String> set = new HashSet<String>();
 *     for (int i = 0; i < object.size(); i++) {
 *         set.add(object.get(i).toString());//object里有重复的数据，采用set去除重复的数据
 *     }
 *     String[] devOnlyIds = new String[set.size()];
 *     //Set-->数组
 *     set.toArray(devOnlyIds);
 *     return devOnlyIds;
 * }
 * 复制代码
 * 总结：
 *
 * 　　1、集合转数组用方法，比如：list.toArray(new String[list.size()])；
 *
 * 　　2、利用set去除list里面重复的数据
 * */