package bookcode.marchonoffer.linkedlist;

import java.util.HashMap;

import bookcode.marchonoffer.entity.RandNode;
/**
 * 复制含有随机指针节点的链表
 * 进阶：不使用额外的数据结构
 * @author Valiant
 *
 */
public class CopyRandLinkedList {
	/**
	 * 时间复杂度为O(N)，额外空间复杂度为O(N)，使用了一个hashMap
	 * @param head
	 * @return
	 */
	public RandNode copy(RandNode head) {
		RandNode cur = head;
		HashMap<RandNode, RandNode> map = new HashMap<>();
		//首先复制节点值
		while (cur != null) {
			map.put(cur, new RandNode(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
		}
		return map.get(head);
	}
	/**
	 * 进阶方法：
	 * 1.首先复制节点，连接到原节点中间，产生新的链表
	 * 2.遍历新的链表，为所有的rand复制
	 * 3.将新旧节点分离开来，返回新节点头
	 * @param head
	 * @return
	 */
	public RandNode copyBetter(RandNode head) {
		if (head == null) {
			return head;
		}
		RandNode cur = head;
		RandNode next = null;
		//复制节点插入到旧节点后
		while (cur != null) {
			next = cur.next;
			cur.next = new RandNode(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		while (cur != null) {
			//如果rand值为null是，是不能直接赋值为cur.rand.next的，会出现空指针异常
			cur.next.rand = cur.rand == null ? null : cur.rand.next;
			cur = cur.next.next;
		}
		RandNode newHead = head.next;
		cur = newHead;
		while (cur.next != null) {
			next = cur.next.next;
			cur.next = cur.next.next;
			cur = next;
		}
		return newHead;
	}
}
