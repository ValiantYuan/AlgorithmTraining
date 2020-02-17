package bookcode.marchonoffer;

import static org.junit.Assert.assertEquals;

import bookcode.marchonoffer.linkedlist.RemoveLastKthNode;
import org.junit.Test;

import bookcode.marchonoffer.entity.DoubleNode;
import bookcode.marchonoffer.entity.Node;
public class RemoveLastKthNodeTest {

	@Test
	public void testRemoveLastKthNodeNodeInt() {
		Node head = new Node(0);
		Node cur = head;
		for (int i = 1; i < 5; i++) {
			Node node = new Node(i);
			cur.next = node;
			cur = node;
		}
		head = new RemoveLastKthNode().removeLastKthNode(head, 5);
		assertEquals("1 2 3 4 ", Node.printLinkedNodeListValue(head));
		
	}

	@Test
	public void testRemoveLastKthNodeDoubleNodeInt() {
		DoubleNode head = new DoubleNode(0);
		DoubleNode cur = head;
		for (int i = 1; i < 5; i++) {
			DoubleNode node = new DoubleNode(i);
			cur.next = node;
			node.last = cur;
			cur = node;
		}
		assertEquals(head.next, new RemoveLastKthNode().removeLastKthNode(head, 5));
	}

}
