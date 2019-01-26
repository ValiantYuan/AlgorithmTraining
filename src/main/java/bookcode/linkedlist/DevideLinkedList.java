package bookcode.linkedlist;

import java.util.Stack;

import bookcode.linkedlist.entity.Node;

/**
 * 将单向链表按某值划分为左边小、中间相等、右边大的形式
 * 进阶：额外空间复杂度为O(1)
 * @author Valiant
 *
 */
public class DevideLinkedList {
	/**
	 * 时间复杂度为O(N), 额外空间复杂度为O(N)
	 * @param head
	 * @param pivot
	 * @return
	 */
	public Node DevideByStack(Node head, int pivot) {
		Node newHead = null;
		
		//当链表为空或者只有一个元素时，直接返回
		if (head == null || head.next == null) {
			return head;
		}
		
		Stack<Node> smaller = new Stack<>();
		Stack<Node> bigger = new Stack<>();
		Stack<Node> same = new Stack<>(); 
		Node cur = head;
		//遍历链表把值放入不同的栈中
		while (cur != null) {
			if (cur.value < pivot) {
				smaller.push(cur);
			} else if (cur.value > pivot) {
				bigger.push(cur);
			} else {
				same.push(cur);
			}
			cur = cur.next;
		}
		//指定新的链表头
		if (!smaller.isEmpty()) {
			newHead = smaller.pop();
		} else if (!same.isEmpty()) {
			newHead = same.pop();
		} else {
			newHead = bigger.pop();
		}
		cur = newHead;
		while (!smaller.isEmpty()) {
			cur.next = smaller.pop();
			cur = cur.next;
		}
		while (!same.isEmpty()) {
			cur.next = same.pop();
			cur = cur.next;
		}
		while (!bigger.empty()) {
			cur.next = bigger.pop();
			cur = cur.next;
		}
		//指定链表尾部
		cur.next = null;
		return newHead;
	}
	
	/**
	 * 使用多个指针替代栈来记录，将一个链表拆为三个链表再组合起来
	 * @param head
	 * @param pivot
	 * @return
	 */
	public Node DevideByLinkedList(Node head, int pivot) {
		//当链表为空或者只有一个元素时，直接返回
		if (head == null || head.next == null) {
			return head;
		}
		
		Node newHead = null;
		Node biggerHead = null;
		Node biggerCur = null;
		Node smallerHead = null;
		Node smallerCur = null;
		Node sameHead = null;
		Node sameCur = null;
		Node cur = head;
		//将一个链表通过一次遍历拆解为3个链表
		while (cur != null)	{
			if (cur.value > pivot) {
				if (biggerHead == null) {
					biggerHead = cur;
					biggerCur = cur;
				} else {
					biggerCur.next = cur;
					biggerCur = biggerCur.next;
				}
			} else if (cur.value < pivot) {
				if (smallerHead == null) {
					smallerHead = cur;
					smallerCur = cur;
				} else {
					smallerCur.next = cur;
					smallerCur = smallerCur.next;
				}
			} else {
				if (sameHead == null) {
					sameHead = sameCur = cur;
				} else {
					sameCur.next = cur;
					sameCur = sameCur.next;
				}
			}
			cur = cur.next;
		}
		sameCur.next = biggerCur.next = smallerCur.next = null;
		if (smallerCur != null) {
			smallerCur.next = sameHead;
			sameCur = sameCur == null ? smallerCur : sameCur;
		}
		if (sameCur != null) {
			sameCur.next = biggerCur;
		}
		
		return smallerHead != null ? smallerHead : sameHead != null ? sameHead : biggerHead;
	}
}
