package leetcode.primarytest.linkedlist;

import basestructure.ListNode;

/**
 * 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author Valiant
 *
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
        //递归的方法特别慢
        // if(head == null) return null;
        // ListNode node,res;
        // res = reverseList(head.next);
        // if(res != null) {
        //     node = res;
        //     while(node.next != null) {
        //       node = node.next;
        //     }
        //     node.next = head;
        //     head.next = null;
        //     return res;
        // } else {
        //     return head;
        // }
    }
}
