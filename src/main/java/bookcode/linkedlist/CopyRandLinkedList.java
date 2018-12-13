package bookcode.linkedlist;

import java.util.HashMap;

import javax.xml.soap.Node;

import bookcode.linkedlist.entity.RandNode;
/**
 * ���ƺ������ָ��ڵ������
 * ���ף���ʹ�ö�������ݽṹ
 * @author Valiant
 *
 */
public class CopyRandLinkedList {
	/**
	 * ʱ�临�Ӷ�ΪO(N)������ռ临�Ӷ�ΪO(N)��ʹ����һ��hashMap
	 * @param head
	 * @return
	 */
	public RandNode copy(RandNode head) {
		RandNode cur = head;
		HashMap<RandNode, RandNode> map = new HashMap<>();
		//���ȸ��ƽڵ�ֵ
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
	 * ���׷�����
	 * 1.���ȸ��ƽڵ㣬���ӵ�ԭ�ڵ��м䣬�����µ�����
	 * 2.�����µ�����Ϊ���е�rand����
	 * 3.���¾ɽڵ���뿪���������½ڵ�ͷ
	 * @param head
	 * @return
	 */
	public RandNode copyBetter(RandNode head) {
		if (head == null) {
			return head;
		}
		RandNode cur = head;
		RandNode next = null;
		//���ƽڵ���뵽�ɽڵ��
		while (cur != null) {
			next = cur.next;
			cur.next = new RandNode(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		while (cur != null) {
			//���randֵΪnull�ǣ��ǲ���ֱ�Ӹ�ֵΪcur.rand.next�ģ�����ֿ�ָ���쳣
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
