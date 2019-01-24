package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import bookcode.linkedlist.ReverseLinkedListPartly;
import bookcode.linkedlist.entity.Node;

public class ReverseLinkedListPartlyTest {

	@Test
	public void testReversePartly() {
		Node head = new Node(0);
		Node cur = head;
		for (int i = 1; i < 5; i++) {
			Node node = new Node(i);
			cur.next = node;
			cur = node;
		}
		head = new ReverseLinkedListPartly().reversePartly(head, 2, 4);
		assertEquals("0 3 2 1 4 ", Node.printLinkedNodeListValue(head));
	}

}
