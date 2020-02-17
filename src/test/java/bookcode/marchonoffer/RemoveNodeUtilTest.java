package bookcode.marchonoffer;

import static org.junit.Assert.*;

import bookcode.marchonoffer.linkedlist.RemoveNodeUtil;
import org.junit.Test;

import bookcode.marchonoffer.entity.Node;

public class RemoveNodeUtilTest {

	@Test
	public void testRemoveMiddle() {
		Node head = new Node(0);
		Node cur = head;
		for (int i = 1; i < 5; i++) {
			Node node = new Node(i);
			cur.next = node;
			cur = node;
		}
		new RemoveNodeUtil().removeMiddle(head);
		assertEquals("0 1 3 4 ", Node.printLinkedNodeListValue(head));
		
	}

	@Test
	public void testRemoveVeryNumber() {
		Node head = new Node(0);
		Node cur = head;
		for (int i = 1; i < 5; i++) {
			Node node = new Node(i);
			cur.next = node;
			cur = node;
		}
		int a = 2, b = 3;
		new RemoveNodeUtil().removeVeryNumber(head, a, b);
		assertEquals("0 1 2 4 ", Node.printLinkedNodeListValue(head));
	}

}
