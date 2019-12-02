package leetcode.explore.interview.primarytest.linkedlist;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/submissions/
 * @author Valiant
 *
 */
public class LRUCacheEasy {
	public static void main(String[] args) {
		LRUCacheEasy cache = new LRUCacheEasy(2);
//		System.out.println(cache.get(2));
		cache.put(2, 1);
//		System.out.println(cache.get(2));
		cache.put(1, 1);
		cache.put(2, 3);
//		System.out.println(cache.get(2));
		cache.put(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
	
	int capacity = 0;
	int size = 0;
	DoubleNode head = null;
	DoubleNode tail = null;
	HashMap<Integer, DoubleNode> map = new HashMap<>();
    public LRUCacheEasy(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
        	DoubleNode node = map.get(key);
        	if (node != head) {
        		if (node == tail) tail = tail.pre;
        		node.pre.next = node.next;
        		putToHead(node);
        	}
        	return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
        	map.get(key).value = value;
        	get(key);
        	return;
        }
        DoubleNode node = new DoubleNode(key, value);
        if (size == 1) tail.pre = node; 
        if (size >= capacity) {
        	map.remove(tail.key);
        	tail.pre.next = tail.next;
        	tail = tail.pre;
        	size--;
        }
        putToHead(node);
        map.put(key, node);
        size++;
    }
    
    public void putToHead(DoubleNode node) {
    	if (head == null) {
    		head = node;
    		tail = node;
    		return;
    	}
    	head.pre = node;
    	node.next = head;
    	node.pre = null;
    	head = node;
    }
    
    static class DoubleNode {
    	int key;
    	int value;
    	DoubleNode pre;
    	DoubleNode next;
    	
    	public DoubleNode(int key, int value) {
			// TODO Auto-generated constructor stub
    		this.key = key;
    		this.value = value;
		}
    }
}
