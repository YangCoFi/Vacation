package com.yang.algo.leetcode;

import java.util.List;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up:
 * Can you solve it without using extra space?
 * */

public class LinkedListCycleII {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null){
                return null;        //无环
            }else {
                fast = fast.next.next;
            }
        }while (fast != slow);
        fast = head;
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
