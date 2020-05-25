package leetcode.problem.hard;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

import basestructure.ListNode;

/**
 * @ClassName MergeKLists
 * @Description: 23. 合并K个排序链表
 * @Author: YuanQi
 * @Date: 2020/2/22
 */
public class MergeKLists {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(3);
        lists[0].next = new ListNode(6);
        lists[0].next.next = new ListNode(16);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(7);
        lists[1].next.next = new ListNode(11);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(4);
        lists[2].next.next = new ListNode(26);

        new MergeKLists().mergeKLists(lists).print();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // PriorityQueue默认是一个小顶堆，假设队列是从小到大排列的，已经可以满足要求了
        PriorityQueue<Container> smallTopHeap = new PriorityQueue<>(lists.length, Container::compareTo);
        ListNode[] validHead = new ListNode[lists.length];

        int validNumber = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                validHead[validNumber] = lists[i];
                validNumber++;
                smallTopHeap.offer(new Container(lists[i], i));
            }
        }
        if (validNumber == 0) return null;
        if (validNumber == 1) return validHead[0];
        ListNode sentinel = new ListNode(0);
        ListNode head = sentinel;
        while(Arrays.stream(validHead).anyMatch(Objects::nonNull)) {
            Container container = smallTopHeap.poll();
            ListNode curNode = container.node;
            int listIndex = container.listIndex;
            head.next = curNode;
            head = head.next;
            smallTopHeap.offer(new Container(validHead[listIndex], listIndex));
            validHead[listIndex] = validHead[listIndex].next;
        }
        while(!smallTopHeap.isEmpty()) {
            head.next = smallTopHeap.poll().node;
            head = head.next;
        }
        return sentinel.next;
    }

    static class Container implements Comparable<Container>{
        ListNode node;
        int listIndex;

        @Override
        public int compareTo(Container o) {
            return this.node.val - o.node.val;
        }

        public Container(ListNode node, int listIndex) {
            this.node = node;
            this.listIndex = listIndex;
        }
    }
}
