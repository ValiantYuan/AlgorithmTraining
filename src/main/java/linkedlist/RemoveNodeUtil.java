package linkedlist;


import linkedlist.entity.Node;
/**
 * �ֱ�ʵ���Ƴ������м�ڵ������a/b���ڵ�ķ���
 * @author Valiant
 *
 */
public class RemoveNodeUtil {

	
	public Node removeMiddle(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node pre = head;
		Node cur = head.next.next;
		while (cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}
	
	public Node removeVeryNumber(Node head, int a, int b) {
		//�Ų��쳣���
		if (head == null || head.next == null || a * b == 0 || a > b) {
			return head;
		}
		//a/b�ڵ�ÿ����һ�����������ĳ���
		int range = b % a == 0 ? b / a : b / a + 1;
		Node pre = new Node(0);
		pre.next = head;
		//��Ҫ�ӱ�ͷ��ʼ���㵱ǰ������ѭ��ֹͣʱ����ǰָ��ָ����Ǳ����������һ���ڵ�
		Node cur = pre;
		while (cur.next != null) {
			pre = pre.next;
			for (int i = 0; i < range; i++) {
				if (cur.next == null) {
					break;
				}
				cur = cur.next;
			}
		}
		pre.next = pre.next.next;
		return head;
	}
	
}
