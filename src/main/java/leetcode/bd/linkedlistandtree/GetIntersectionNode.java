package leetcode.bd.linkedlistandtree;

import basestructure.ListNode;

/**
 * @NAME: GetIntersectionNode
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION: 编写一个程序，找到两个单链表相交的起始节点。
 **/
public class GetIntersectionNode {


    /**
     *
     * @param headA
     * @param headB
     * @return 神仙简化，膜拜
     */
    public ListNode getIntersectionNodeSimple(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pathA = headA;
        ListNode pathB = headB;
        //如果pathA和pathB两者同为null，此处循环也会终止，注意！不会死循环
        while(pathA != pathB) {
            pathA = pathA == null ? headB : pathA.next;
            pathB = pathB == null ? headA : pathB.next;

        }
        return pathA;
    }

    /**
     *
     * @param headA
     * @param headB
     * @return 自己写的答案
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pathA = headA;
        ListNode pathB = headB;
        //循环终止条件保证一条路径遍历完成时
        while(pathA != null && pathB != null) {
            if (pathA == pathB) {
                return pathA;
            }
            pathA = pathA.next;
            pathB = pathB.next;
        }
        if (pathA == null) {
            pathA = headB;
        } else {
            pathB = headA;
        }
        while(pathA != null && pathB != null) {
            if (pathA == pathB) {
                return pathA;
            }
            pathA = pathA.next;
            pathB = pathB.next;
        }
        if (pathA == null) {
            pathA = headB;
        } else {
            pathB = headA;
        }
        while(pathA != null && pathB != null) {
            if (pathA == pathB) {
                return pathA;
            }
            pathA = pathA.next;
            pathB = pathB.next;
        }
        return null;
    }
}
