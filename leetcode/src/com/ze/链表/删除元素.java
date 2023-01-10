package com.ze.链表;

/**
 * author ze
 * date 2023-01-04 21:22
 */

public class 删除元素 {

    public ListNode removeElements(ListNode head, int val) {
        //插入头结点
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode q = node;
        while (q.next != null) {
            if (q.next.val == val) {
                q.next = q.next.next;
            } else {
                q = q.next;
            }
        }
        return node.next;
    }

}
