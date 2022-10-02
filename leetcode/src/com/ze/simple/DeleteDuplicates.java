package com.ze.simple;

/**
 * @author ze
 * @creat 2022-10-01 22:20
 */
public class DeleteDuplicates {

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

    //双指针问题
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next, nus = head;
        while(fast != null && slow != null){
            if(fast.val > slow.val){
                slow = slow.next;
                slow.val = fast.val;
                nus = slow;
            }
            fast = fast.next;
        }
        nus.next = null;
        return head;
    }

}
