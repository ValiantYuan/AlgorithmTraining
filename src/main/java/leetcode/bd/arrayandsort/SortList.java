package leetcode.bd.arrayandsort;

import basestructure.ListNode;

/**
 * @NAME: SortList
 * @USER: valiant
 * @DATE: 2019-09-29
 * @DESCRITION: 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 **/
public class SortList {

    /**
     * 递归方法没有实现常数级空间复杂度
     * @param head
     * @return
     */
    public ListNode sortListUseRecursive(ListNode head) {
        //边界条件处理
        if (head == null || head.next == null) {
            return head;
        }
        //这里有两种写法，在判断链表中点时，如果快指针从head起始，那么终止条件是fast.next和fast.next.next都不为null
        //如果快指针从head.next起始，那么终止条件是fast和fast.next都不为null
        ListNode slow = head, fast = head.next, secHead;
        //快慢指针找到链表的中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        ListNode slow = head, fast = head, secHead;
//        //快慢指针找到链表的中点
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
        //把链表断开，头指针分别为head和secHead
        secHead = slow.next;
        slow.next = null;
        ListNode left = sortListUseRecursive(head);
        ListNode right = sortListUseRecursive(secHead);
        return merge(left, right);
    }

    /**
     * 合并两个有序链表
     * @param head1
     * @param head2
     * @return
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return head.next;
    }
}
