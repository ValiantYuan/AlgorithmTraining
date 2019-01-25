package geektimepractice.linkedlist;

import bookcode.linkedlist.entity.Node;

public class LinkedListWithoutSentinel {
Node head;
	
	public LinkedListWithoutSentinel(int value) {
		// TODO Auto-generated constructor stub
		head = null;
	}
	
	/**
	 * 添加一个节点,如果head是空，需要特殊处理
	 * @param node
	 */
	public void add(Node node) {
		if (head == null) {
			head = node;
			return;
		}
		//next指向当前head,next.next不为空时，next向后移动一个节点
		Node next = head;
		while (next.next != null) {
			next = next.next;
		}
		next.next = node;
	}
	/**
	 * 删除一个节点,如果head为空，直接返回或者返回错误，需要特殊处理
	 * 如果删除头节点，即删除最后一个有效节点，也需要特殊处理
	 * @param node
	 */
	public void delete(Node node) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node pre = null;
		//查询继续条件：当前节点不等于查询节点，且下一个节点不为空
		while (cur != node && cur.next != null) {
			pre = cur;
			cur = cur.next;
		}
		/**
		 * 查询结束，如果找到了，则当前节点等于查询节点
		 * 如果删除头节点，则返回空的头
		 * 如果没有找到，则什么都不做
		 */
		if (cur == node) {
			if (cur == head) {
				head = null;
				return;
			} else {
				pre.next = cur.next;
			} 
		}
	}
	/**
	 * 是否包含节点，包含则返回第一个匹配的节点
	 * @param node
	 * @return
	 */
	public Node contains(Node node) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		while (cur != node && cur.next != null) {
			cur = cur.next;
		}
		return cur == node ? cur : null;
	}
	
	/**
	 * 返回该值所在的节点
	 * @param value
	 * @return
	 */
	public Node findValue(int value) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		while (cur.value != value && cur.next != null) {
			cur = cur.next;
		}
		return cur.value == value ? cur : null;
	}
}
