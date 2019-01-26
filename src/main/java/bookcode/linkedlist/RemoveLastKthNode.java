package bookcode.linkedlist;

import bookcode.linkedlist.entity.DoubleNode;
import bookcode.linkedlist.entity.Node;

/**
 * 实现两个函数，删除单链表中倒数第K个元素和双链表中倒数第K的元素
 * 时间复杂度O(N),额外空间复杂度O(1)
 * @author Valiant
 *
 */
public class RemoveLastKthNode {
	
	public Node removeLastKthNode(Node head, int k) {
		if (head == null) {
			return head;
		}
		int pos = 1;
		Node node = head;
		Node pre = new Node(0);
		pre.next = head;
		while (node.next != null) {
			node = node.next;
			pos++;
			if (pos > k) {
				pre = pre.next;
			}
		}
		if (pos > k) {
			pre.next = pre.next.next;
		} else if (pos == k) {
			head = head.next;
		}
		return head;
	}
	
	/**
	 * 双向链表与单向类似，只要注意last的重连接即可
	 * @param head
	 * @param k
	 * @return
	 */
	public DoubleNode removeLastKthNode(DoubleNode head, int k) {
		if (head == null) {
			return head;
		}
		int pos = 1;
		DoubleNode node = head;
		DoubleNode pre = new DoubleNode(0);
		pre.next = head;
		while (node.next != null) {
			node = node.next;
			pos++;
			if (pos > k) {
				pre = pre.next;
			}
		}
		if (pos > k) {
			pre.next.last = pre;
			pre.next = pre.next.next;
		} else if (pos == k) {
			head.next.last = null;
			head = head.next;
		}
		return head;
	}

}

