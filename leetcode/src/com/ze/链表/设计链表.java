package com.ze.链表;

import org.junit.Test;

/**
 * author ze
 * date 2023-01-05 20:39
 */

public class 设计链表 {
    @Test
    public void test() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
//        System.out.println(linkedList.get(1));            //返回2
        linkedList.addAtHead(0);
        ListNode p = linkedList.head.next;

//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3

//        System.out.println(linkedList.get(1));           //返回3
    }
}
