package leetcode.primarytest.linkedlist;

import basestructure.ListNode;

public class DeleteNode {
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
