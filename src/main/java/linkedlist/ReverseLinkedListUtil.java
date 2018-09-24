package linkedlist;

import linkedlist.entity.DoubleNode;
import linkedlist.entity.Node;

/**
 * ��ת�����˫������
 * @author Valiant
 *
 */
public class ReverseLinkedListUtil {

	public Node reverseLinkedList(Node head) {
		
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
		
	public DoubleNode reverseLinkedList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
	
}
