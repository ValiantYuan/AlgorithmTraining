package bookcode.linkedlist;

import java.util.Stack;

import bookcode.linkedlist.entity.Node;

/**
 * ����������ĳֵ����Ϊ���С���м���ȡ��ұߴ����ʽ
 * ���ף�����ռ临�Ӷ�ΪO(1)
 * @author Valiant
 *
 */
public class DevideLinkedList {
	/**
	 * ʱ�临�Ӷ�ΪO(N), ����ռ临�Ӷ�ΪO(N)
	 * @param head
	 * @param pivot
	 * @return
	 */
	public Node DevideByStack(Node head, int pivot) {
		Node newHead = null;
		
		//������Ϊ�ջ���ֻ��һ��Ԫ��ʱ��ֱ�ӷ���
		if (head == null || head.next == null) {
			return head;
		}
		
		Stack<Node> smaller = new Stack<>();
		Stack<Node> bigger = new Stack<>();
		Stack<Node> same = new Stack<>(); 
		Node cur = head;
		//���������ֵ���벻ͬ��ջ��
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
		//ָ���µ�����ͷ
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
		//ָ������β��
		cur.next = null;
		return newHead;
	}
	
	/**
	 * ʹ�ö��ָ�����ջ����¼����һ�������Ϊ�����������������
	 * @param head
	 * @param pivot
	 * @return
	 */
	public Node DevideByLinkedList(Node head, int pivot) {
		//������Ϊ�ջ���ֻ��һ��Ԫ��ʱ��ֱ�ӷ���
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
		//��һ������ͨ��һ�α������Ϊ3������
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
