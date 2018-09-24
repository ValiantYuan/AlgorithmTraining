package linkedlist;


import linkedlist.entity.Node;
/**
 * 分别实现移除链表中间节点和链表a/b处节点的方法
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
		//排查异常情况
		if (head == null || head.next == null || a * b == 0 || a > b) {
			return head;
		}
		//a/b节点每往后一步所需的链表的长度
		int range = b % a == 0 ? b / a : b / a + 1;
		Node pre = new Node(0);
		pre.next = head;
		//需要从表头开始计算当前步长，循环停止时，当前指针指向的是本步长的最后一个节点
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
