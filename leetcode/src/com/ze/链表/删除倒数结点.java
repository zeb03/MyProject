package com.ze.链表;

import org.junit.Test;

/**
 * author ze
 * date 2023-01-06 22:50
 */
public class 删除倒数结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0, head);
        ListNode left, right;
        left = dummyNode;
        right = dummyNode;
        //记录链表长度
        int len = 0;
        //走到最后一个结点
        while (right.next != null) {
            right = right.next;
            len++;
        }
        //将left移到被删除结点的前一个结点
        for (int i = 0; i < len - n; i++) {
            left = left.next;
        }
        left.next = left.next.next;
        return dummyNode.next;
    }

    @Test
    public void test(){
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        removeNthFromEnd(list.head.next,2);
        list.print();
    }
}
