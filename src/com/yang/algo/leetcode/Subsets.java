package com.yang.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Subsets
 * @Description Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 *
 * For example,
 * If S =[1,2,3], a solution is:
 * [↵  [3],↵  [1],↵  [2],↵  [1,2,3],↵  [1,3],↵  [2,3],↵  [1,2],↵  []↵]
 * @Author YangC
 * @Date 2019/9/28 20:29
 **/
public class Subsets {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(S);
        for (int j = 0; j < S.length; j ++){        //j是表示此时找几个数的子集
            backtracking(S, j, 0, list);
        }
        return result;
    }

    private void backtracking(int[] s, int j, int start, List<Integer> list) {
        if (j < 0){
            return;
        }else if (j == 0){
            result.add(new ArrayList<>(list));
        }else {
            for (int i = start; i < s.length; i ++){
                list.add(s[i]);
                backtracking(s, j - 1, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
