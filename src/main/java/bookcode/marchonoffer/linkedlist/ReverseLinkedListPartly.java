package bookcode.marchonoffer.linkedlist;

import bookcode.marchonoffer.entity.Node;

public class ReverseLinkedListPartly {
	
	
	public Node reversePartly(Node head, int from, int to) {
		int len = 0;
		//from节点前一个节点的引用
		Node fPre = null;
		//to后一个节点的引用
		Node tPost = null;
		//当前节点的引用
		Node node1 = head;
		while (node1 != null) {
			len++;
			fPre = len == from - 1 ? node1 : fPre;
			tPost = len == to + 1 ? node1 : tPost;
			node1 = node1.next;
		}
		if (from > to || from < 1 || to > len) {
			return head;
		}
		//如果from是表头，则要特殊处理
		
		node1 = fPre == null ? head :fPre.next;
		//反转from到to的节点
		Node node2 = node1.next;
		Node next = null;
		node1.next = tPost;
		while (node2 != tPost) {
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if (fPre != null) {
			fPre.next = node1;
			return head;
		}
		return node1;
	}
}
