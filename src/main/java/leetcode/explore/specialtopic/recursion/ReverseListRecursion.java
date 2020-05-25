package leetcode.explore.specialtopic.recursion;

import basestructure.ListNode;

/**
 * @ClassName ReverseListRecursion
 * @Description:
 * @Author: YuanQi
 * @Date: 2020/2/22
 */
public class ReverseListRecursion {

    public ListNode reverseList(ListNode head) {
        // head = null时，表示为空链表
        // head.next = null时，表示head已经时表尾
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
