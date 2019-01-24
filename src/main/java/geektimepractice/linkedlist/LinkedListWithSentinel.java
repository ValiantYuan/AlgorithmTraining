package geektimepractice.linkedlist;

import bookcode.linkedlist.entity.Node;

/**
 * ���ڱ�������ͷʼ��ָ��head,���ڱ�������ֻ��ʹ�ÿձ����ʱ��ɾ�����һ���ڵ�Ĳ���ͬһ�����ڿձ�����⴦����Ȼ���ܱ���
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
	 * ���һ���ڵ�,��û���ڱ���ȣ�ֱ�ӿ�����ӣ�����Ҫ�ж�head�Ƿ��ǿ�
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
	 * ɾ��һ���ڵ�
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
	 * �Ƿ�����ڵ㣬�������ص�һ��ֵ
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
	 * ���ظ�ֵ���ڵĽڵ�
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
