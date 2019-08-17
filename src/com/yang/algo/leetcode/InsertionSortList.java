package com.yang.algo.leetcode;

import java.util.List;

/**
 * Sort a linked list using insertion sort.
 * */

public class InsertionSortList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dumyNode = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dumyNode;
        while(cur != null){
            ListNode next = cur.next;
            pre = dumyNode;
            while (pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dumyNode.next;
    }
}
