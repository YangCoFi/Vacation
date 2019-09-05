package com.yang.algo.SwordToOffer;

import java.util.List;

/**
 * @ClassName DelDuplicateNodesInLnkedList
 * @Description 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Author YangC
 * @Date 2019/8/31 15:25
 **/
public class DelDuplicateNodesInLnkedList {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

//    public static ListNode deleteDuplication(ListNode pHead) {
//        //首先确定头节点
//        if (pHead == null || pHead.next == null) {
//            return pHead;
//        }
//        ListNode hHead = pHead;
//        while (hHead.val == hHead.next.val) {
//            hHead = hHead.next;
//        }
//        pHead = hHead.next;
//        hHead.next = null;
//        //找到头节点后开始进行删除
//        ListNode tempNode = pHead;
//        while (tempNode != null && tempNode.next != null){
//            if (tempNode.val == tempNode.next.val){
//                tempNode = tempNode.next;
//            }
//        }
//    }
}
