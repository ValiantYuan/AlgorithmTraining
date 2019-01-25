package bookcode.linkedlist;

import bookcode.linkedlist.entity.Node;

public class ReverseLinkedListPartly {
	
	
	public Node reversePartly(Node head, int from, int to) {
		int len = 0;
		//from�ڵ�ǰһ���ڵ������
		Node fPre = null;
		//to��һ���ڵ������
		Node tPost = null;
		//��ǰ�ڵ������
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
		//���from�Ǳ�ͷ����Ҫ���⴦��
		
		node1 = fPre == null ? head :fPre.next;
		//��תfrom��to�Ľڵ�
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
