package com.yang.algo.leetcode;

import java.util.List;

/**
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * */

public class ReorderList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sechead = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (sechead != null) {
            ListNode next = sechead.next;
            sechead.next = pre;
            pre = sechead;
            sechead = next;
        }
        sechead = pre;

        while (head != null && sechead != null) {
            ListNode onetemp = head.next;
            ListNode twotemp = sechead.next;


            head.next = sechead;
            head = onetemp;
            sechead.next = head;
            sechead = twotemp;
        }
    }
}
