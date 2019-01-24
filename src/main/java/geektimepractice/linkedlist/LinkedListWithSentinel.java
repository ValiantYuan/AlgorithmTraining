package geektimepractice.linkedlist;

import bookcode.linkedlist.entity.Node;

/**
 * 带哨兵的链表头始终指向head,带哨兵的链表只能使得空表插入时和删除最后一个节点的操作同一，对于空表的特殊处理依然不能避免
 * @author Valiant
 *
 */
public class LinkedListWithSentinel {
	Node head;
	Node sentry = new Node();
	
	public LinkedListWithSentinel(int value) {
		// TODO Auto-generated constructor stub
		head = sentry;
	}
	
	/**
	 * 添加一个节点,与没有哨兵相比，直接可以添加，不需要判断head是否是空
	 * @param node
	 */
	public void add(Node node) {
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = node;
	}
	/**
	 * 删除一个节点
	 * @param node
	 */
	public void delete(Node node) {
		if (head.next == null) {
			return;
		}
		Node cur = head;
		while (cur != null && cur.next != node) {
			cur = cur.next;
		}
		if (cur.next == node) {
			cur.next = cur.next.next;
		}
	}
	/**
	 * 是否包含节点，包含返回第一个值
	 * @param node
	 * @return
	 */
	public Node contains(Node node) {
		if (head.next == null) {
			return null;
		}
		Node cur = head.next;
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
		if (head.next == null) {
			return null;
		}
		Node cur = head.next;
		while (cur.value != value && cur.next != null) {
			cur = cur.next;
		}
		return cur.value == value ? cur : null;
	}
	
}
