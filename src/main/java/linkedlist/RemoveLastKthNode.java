package linkedlist;

import linkedlist.entity.DoubleNode;
import linkedlist.entity.Node;

/**
 * ʵ������������ɾ���������е�����K��Ԫ�غ�˫�����е�����K��Ԫ��
 * ʱ�临�Ӷ�O(N),����ռ临�Ӷ�O(1)
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
	 * ˫�������뵥�����ƣ�ֻҪע��last�������Ӽ���
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

