package leetcode.explore.interview.primarytest.linkedlist;

import basestructure.ListNode;

/**
 * @NAME: DetectCycle
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
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
        //相交节点和头指针同时开始移动，直到相交，相交处即环的起始点
        while(head != intersect) {
            head = head.next;
            intersect = intersect.next;
        }
        return head;
    }

    /**
     *
     * @param head
     * @return 返回快慢指针相交的节点
     */
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
