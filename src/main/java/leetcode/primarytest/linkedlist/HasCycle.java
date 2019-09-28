package leetcode.primarytest.linkedlist;

import basestructure.ListNode;

/**
 * @NAME: HasCycle
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION:
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //注意终结条件以fast进行判断
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
