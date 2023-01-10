package com.ze.链表;

import org.junit.Test;

/**
 * author ze
 * date 2023-01-06 22:09
 */
public class 交换结点 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0, head);
        if (head == null) {
            return null;
        }
        ListNode pre = node;
        while (head != null && head.next != null) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = head;
            pre.next = cur;
            pre = head;
            head = head.next;
        }
        return node.next;
    }
    @Test
    public void test(){
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.head = swapPairs(list.head.next);
        list.print();
    }
}
