package leetcode.problem.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

import basestructure.ListNode;
import leetcode.problem.hard.MergeKLists.Container;

/**
 * @ClassName MergeKListNew
 * @Description: 23. 合并K个排序链表
 * @Author: YuanQi
 * @Date: 2020/2/22
 */
public class MergeKListNew {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // PriorityQueue默认是一个小顶堆，假设队列是从小到大排列的，已经可以满足要求了
        PriorityQueue<ListNode> smallTopHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        // 建立链表的表头
        ListNode sentinel = new ListNode(0);
        ListNode head = sentinel;
        // 将链表数组中不为空的头节点入堆
        for (ListNode node: lists) {
            if (node != null) smallTopHeap.offer(node);
        }
        while (!smallTopHeap.isEmpty()) {
            // 小顶堆中最小的值出堆，并接到当前链表的末尾
            head.next = smallTopHeap.poll();
            head = head.next;
            // 如果表尾元素的下一个节点不为空，则入堆
            // 循环指导堆中为空，处理结束
            if (head.next != null) smallTopHeap.offer(head.next);
        }
        return sentinel.next;
    }
}
