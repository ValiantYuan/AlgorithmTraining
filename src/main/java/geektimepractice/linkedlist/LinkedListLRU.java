package geektimepractice.linkedlist;

import java.util.concurrent.ConcurrentHashMap;


/**
 * 链表实现的LRU结构
 * @author valiant
 *
 */
public class LinkedListLRU implements LRU <Integer, DoubleNode> {
	//用Integer标示的标号代表网页编号，String代表网页内容
	public static DoubleNode head= null;
	public static DoubleNode tail = null;
	public static ConcurrentHashMap<Integer, DoubleNode> map = new ConcurrentHashMap<>();
	public static final int LENGTH = 100;
	public static Integer number = 0;
	/**
	 * 可以借助HashMap判断查询内容是否存在，避免遍历链表
	 * @param number
	 * @return
	 */
	@Override
	public DoubleNode gerValue(Integer number) {
		// TODO Auto-generated method stub
		if (map.containsKey(number)) {
			DoubleNode result = map.get(number);
			if (result == tail) {
				tail = result.last;
			}
			result.last.next = result.next;
			add(number, result);
			return map.get(number);
		}
		return null;
	}

	/**
	 * 把一个节点加入到LRU的最前端，如果长度已满，则把最后一个值去掉
	 * @param result
	 */
	@Override
	public void add(Integer number, DoubleNode result) {
		// TODO Auto-generated method stub
		if (result == null) {
			return;
		}
		//当缓存满了时，要把最后一个值移除缓存
		if (map.size() == 100) {
			tail = tail.last;
			tail.next = null;
			map.remove(tail.number);
		}
		head.last = result;
		result.next = head;
		result.last = null;
		head = result;
	}

	@Override
	public Integer getKey() {
		// TODO Auto-generated method stub
		return number++;
	}

}
