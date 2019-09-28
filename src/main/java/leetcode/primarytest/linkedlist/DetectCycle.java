package leetcode.primarytest.linkedlist;

import basestructure.ListNode;

/**
 * @NAME: DetectCycle
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION:
 **/
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }
        while(head != intersect) {
            head = head.next;
            intersect = intersect.next;
        }
        return head;
    }

    public ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //注意终结条件以fast进行判断
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
