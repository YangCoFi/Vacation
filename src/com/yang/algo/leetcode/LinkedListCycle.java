package com.yang.algo.leetcode;

/**
 *Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * */

public class LinkedListCycle {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    //快慢指针能相遇，则说明有环
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null){
                //说明无环
                return false;
            }
            fast = fast.next.next;
        }while (slow != fast);
        return true;
    }
}

