package leetcode.explore.specialtopic.recursion;

import basestructure.ListNode;

/**
 * @ClassName SwapListNodes
 * @Description: 以2为例，实现每n个节点翻转单链表
 * @Author: YuanQi
 * @Date: 2020/2/21
 */
public class SwapListNodes {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = swapNodes(head, 2);
        return newHead;
    }

    /**
     * 每n个节点翻转链表
     * @param curHead
     * @param n
     * @return
     */
    public ListNode swapNodes(ListNode curHead, int n) {
        // curHead为null时，结束
        if (curHead == null) {
            return null;
        }
        ListNode nextHead = curHead;
        ListNode preNext = null;
        int i = 0;
        for (; i < n && nextHead != null; i++) {
            preNext = nextHead;
            nextHead = nextHead.next;
        }
        // 剩余不足n个时，结束，注意终止条件 之前写的i < n - 1 而导致程序不正确
        // 这里正常执行是i等于n，从而for循环结束，非正常结束时，即nextHead == null时，i应该小于n
        if (i < n) {
            return curHead;
        }
        // 为了方便的使用reverseList,把需要翻转的链表最后一个元素的next置为null
        preNext.next = null;
        ListNode curSwapHead = reverseList(curHead);
        // curHead翻转链表后会变成链表尾，与后续链表的头需要相接
        curHead.next = swapNodes(nextHead, n);
        return  curSwapHead;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new SwapListNodes().swapNodes(head, 3).print();
    }

}
