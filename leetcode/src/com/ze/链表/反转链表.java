package com.ze.链表;

/**
 * author ze
 * date 2023-01-06 21:52
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p, temp;
        p = head.next;
        head.next = null;
        while (p != null) {
            temp = p.next;
            p.next = head;
            head = p;
            p = temp;
        }
        return head;
    }

    public ListNode reverseList2(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        return reverse(null, head);
    }
    //把递归看出循环
    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null){
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }
}
