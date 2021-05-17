package leetcode.explore.interview.primarytest.linkedlist;

import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 * @author Valiant
 */

/*运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？*/
public class LRUCache {
    static class DoubleNode {
        int key;
        int value;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode(int key, int value) {
            // TODO Auto-generated constructor stub
            this.key = key;
            this.value = value;
        }
    }

    DoubleNode head = null;
    DoubleNode tail = null;
    HashMap<Integer, DoubleNode> map = new HashMap<Integer, DoubleNode>();


    int capacity = 0;
    int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }


    /**
     *
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    /**
     * 插入数据，包含key时更新value并放到头部，不包含时，把该值放到头部
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            DoubleNode node = new DoubleNode(key, value);
            addToHead(node);
        }
    }

    /**
     * 把节点加到头结点前面
     */
    public void addToHead(DoubleNode node) {
        if (size >= capacity) {
            map.remove(tail.key);
            remove(tail);
        }
        if (head == null) {
            head = node;
            node.next = null;
            node.prev = null;
            tail = node;
            size++;
            map.put(node.key, node);
            return;
        }
        head.prev = node;
        node.next = head;
        head = node;
        head.prev = null;
        size++;
        map.put(node.key, node);
    }

    /**
     * 从节点中移除一个节点，准备丢弃或者准备放到队列头部
     */
    public void remove(DoubleNode node) {
        if (size-- == 1) {
            head = null;
            tail = null;
            return;
        }
        if (node == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }
        if (node == head) {
            head = head.next;
            head.prev = null;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
//		cache.put(1, 2);
    }


}
