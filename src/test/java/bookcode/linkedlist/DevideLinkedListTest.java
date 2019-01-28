package bookcode.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import bookcode.linkedlist.DevideLinkedList;
import bookcode.linkedlist.entity.Node;

public class DevideLinkedListTest {

	@Test
	public void testDevideByStack() {
		Node head = new Node(0);
		Node cur = head;
		for (int i = 1; i < 5; i++) {
			Node node = new Node(i);
			cur.next = node;
			cur = node;
		}
		System.out.println(Node.printLinkedNodeListValue(new DevideLinkedList().DevideByStack(head, 3)));
	}

	@Test
	public void testDevideByLinkedList() {
		Node head = new Node(0);
		Node cur = head;
		for (int i = 1; i < 5; i++) {
			Node node = new Node(i);
			cur.next = node;
			cur = node;
		}
		System.out.println(Node.printLinkedNodeListValue(new DevideLinkedList().DevideByLinkedList(head, 3)));
	}

}
