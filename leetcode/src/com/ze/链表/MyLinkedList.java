package com.ze.链表;

/**
 * author ze
 * date 2023-01-06 22:49
 */
public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode node = new ListNode(val);
        ListNode p = head;
        size++;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode p = head;
        size--;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    public void print() {
        ListNode p = head.next;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
