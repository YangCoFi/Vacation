package com.yang.algo.SwordToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @ClassName BinaryTreePathForCertainValue
 * @Description 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @Author YangC
 * @Date 2019/8/18 19:15
 **/
public class BinaryTreePathForCertainValue {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        findPath(root, target, cur, result);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size() < o2.size()){
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        return result;
    }

    private void findPath(TreeNode root, int target, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> result) {
        if (root == null){
            return;
        }
        int value = root.val;
        cur.add(value);
        if (target == value && root.left == null && root.right == null){
            result.add(new ArrayList<>(cur));
        }else {
            findPath(root.left, target - value, cur, result);
            findPath(root.right, target - value, cur, result);
        }
        cur.remove(cur.size() - 1);
    }

}


/**Collections有两种比较规则方式，第一种是使用自身的比较规则：
 该类必须实现Comparable接口并重写comparTo方法。
 this可以想象为1，传入对象o想象为2，返回1-2即按升序排序。返回2-1即按降序排序。
 *
 * 第二个参数为比较器，可以使用它来定义针对集合排序时的比较元素大小的规则。
 * 使用这种方式时，sort方法不要求集合元素必须实现Comparable接口了，因为不会使用元素自身的比较规则。
 *
 *
 * Comparable接口
 *
 * 该接口对每个实现它的类的对象强加了排序规则。该排序称之为自然排序(natural ordering)。方法public int compareTo(T o)是自然排序的排序方法。
 *
 * 实现了comparable接口类的List或者arrays对象可以通过调用以下方法进行排序：
 * 1. Collections.sort(List<T> list) //内部是调用第二个方法进行排序
 * 2.  Arrays.sort(Object[] a)       //算法是合并排序或二分排序 n^2算法复杂度
 *
 * Comparator接口
 * 通过比较两个入参得到顺序。返回值有三种：
 * 1,入参一大于入参二。
 * 0，入参相同。
 * -1，入参一小于入参二。
 * */