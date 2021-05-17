package leetcode.problem.medium.linkedlist;

import java.util.List;

import basestructure.ListNode;

/**
 * @author : yuanqi
 * @since : 2021/1/26
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode newHead = head;
        ListNode pre = null;
        ListNode next = null;
        ListNode temHead = null;
        ListNode preTemHead = null;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                preTemHead = head;
                head = head.next;
            } else {
                if (i == m) {
                    temHead = head;
                }
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
        }
        temHead.next = head;
        if (m > 1) {
            preTemHead.next = pre;
        }
        return m == 1 ? pre : newHead;
    }



    //recursion
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode reverseHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }

    public ListNode reverseIteration(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseIteration(ListNode head, int n) {
        ListNode pre = null;
        ListNode next = null;
        ListNode temHead = head;
        for (int i = 1; i <= n; i++) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        temHead.next = head;
        return pre;
    }
}
