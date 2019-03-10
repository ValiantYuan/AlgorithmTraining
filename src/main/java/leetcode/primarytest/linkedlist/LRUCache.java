package leetcode.primarytest.linkedlist;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import geektimepractice.linkedlist.DoubleNode;

/**
 * 
 *
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 * @author Valiant
 *
 */

/*运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？*/
public class LRUCache {
	DoubleNode head = null;
	DoubleNode tail = null;
	HashMap<Integer, WeakReference<DoubleNode>> map = new HashMap<>();
    int capacity;
    int count = 0;
	public LRUCache(int capacity) {
		this.capacity = capacity;
    }
    
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		System.out.println(cache.get(2));
		cache.put(2, 6);
		System.out.println(cache.get(1));
		cache.put(1, 5);
		cache.put(1, 2);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
//		cache.put(4, 4);
//		System.out.println(cache.get(4));
	}
	
    public int get(int key) {
    	if (!map.containsKey(key)) return -1;
    	if (map.containsKey(key) && map.get(key).get().value == -1) return -1;
    	DoubleNode node = map.get(key).get();
    	if (count != 1 && node != head) {
    		if (node == tail) tail = tail.last;
    		node.last.next = node.next;
    		if (node.last == head) node.last.last = node;
    		node.last = null;
    		node.next = head;
    		head = node;
    	}
    	return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
        	DoubleNode node = map.get(key).get();
        	if (node.value == -1) return;
        	node.value = value;
        	return;
        }
        DoubleNode node = new DoubleNode(value);
        if (head == null) {
        	head = node;
        	tail = node;
        } else if (count == 1) {
			tail.last = node;
			head.last = node;
			node.next = head;
        	head = node;
		}
        else {
        	if (count >= capacity) {
        		//在这里tail指向的对象将会失去可达性，会被垃圾回收掉，赋值为-1是为了保证在垃圾回收前不再被使用
        		tail.value = -1;
        		tail.last.next = null;
        		tail = tail.last;
        		count--;
        	}
        	head.last = node;
        	node.next = head;
        	head = node;
        	//将弱指针放入HashMap中
        }
        map.put(key, new WeakReference<DoubleNode>(node));
        count++;
    }
}
