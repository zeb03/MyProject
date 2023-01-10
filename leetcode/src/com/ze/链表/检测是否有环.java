package com.ze.链表;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * author ze
 * date 2023-01-08 20:51
 */
public class 检测是否有环 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Map<ListNode, Integer> pointedMap = new HashMap<>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p = dummyNode;
        while (p != null) {
            if (p.next == null) {
                break;
            }
            pointedMap.put(p.next, pointedMap.getOrDefault(p.next, 0) + 1);
            if (pointedMap.get(p.next) > 1){
                return p.next;
            }
            p = p.next;
        }
        return null;
    }

}
