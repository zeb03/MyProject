package com.ze.simple;

/**
 * @author ze
 * @creat 2022-09-22 20:39
 */
/*
两个有序链表合并成一个有序链表
 */
public class LinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
    思路：创建一个头结点，使其指向首元素较小的链表，依次比较两条链表元素的大小，使其插入新链表中。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), p, q;
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        p = (list1.val > list2.val) ? list2 : list1;
        head.next = p;
        while (list1 !=null && list2 != null) {
            if (p == list1) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
            if(list1 == null || list2 == null){
                p.next = list1 == null?list2:list1;
                break;
            }
            if (list1.val < list2.val) {
                p.next = list1;
            } else {
                p.next = list2;
            }
            p = p.next;
        }
        return head.next;
    }

    /*
    思路：创建两个指针,以首元素较小的链表为主链，将另一链中的元素插入主链中
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode p, q;
        boolean isOne = true;
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val >= list2.val) {
            p = list1;
            q = list2;
        } else {
            q = list1;
            p = list2;
            isOne = false;
        }
        ListNode pNext = p.next;
        ListNode qNext = q.next;
        while (q != null || p != null) {
            if (q == null || p == null) {
                break;
            } else if (qNext == null) {
                q.next = p;
                break;
            } else if (p.val <= qNext.val) {
                insertNode(q, p);
                q = p;
                p = pNext;
            } else {
                q = qNext;
            }

            if (p != null) {
                pNext = p.next;
            }
            if (q != null) {
                qNext = q.next;
            }
        }
        if (isOne) {
            return list2;
        } else {
            return list1;
        }
    }

    private void insertNode(ListNode q, ListNode p) {
        p.next = q.next;
        q.next = p;
    }
}
