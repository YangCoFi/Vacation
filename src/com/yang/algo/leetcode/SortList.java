package com.yang.algo.leetcode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * */

public class SortList {

    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;        //断开链表
        return mergeSort(sortList(head),sortList(midNext));     //这和数组不一样的，链表只需头节点即可。数组还要指定末尾，范围
    }

    private ListNode mergeSort(ListNode listNode1, ListNode listNode2) {
        ListNode preHead = new ListNode(0);     //前驱节点，用于找头节点       不要直接在链表上处理，用指针去处理
        ListNode cur = preHead;
        ListNode cur1 = listNode1;
        ListNode cur2 = listNode2;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return preHead.next;
    }

    private static ListNode getMid(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
