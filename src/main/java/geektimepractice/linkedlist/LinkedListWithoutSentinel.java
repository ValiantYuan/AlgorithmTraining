package geektimepractice.linkedlist;

import bookcode.linkedlist.entity.Node;

public class LinkedListWithoutSentinel {
Node head;
	
	public LinkedListWithoutSentinel(int value) {
		// TODO Auto-generated constructor stub
		head = null;
	}
	
	/**
	 * ���һ���ڵ�,���head�ǿգ���Ҫ���⴦��
	 * @param node
	 */
	public void add(Node node) {
		if (head == null) {
			head = node;
			return;
		}
		//nextָ��ǰhead,next.next��Ϊ��ʱ��next����ƶ�һ���ڵ�
		Node next = head;
		while (next.next != null) {
			next = next.next;
		}
		next.next = node;
	}
	/**
	 * ɾ��һ���ڵ�,���headΪ�գ�ֱ�ӷ��ػ��߷��ش�����Ҫ���⴦��
	 * ���ɾ��ͷ�ڵ㣬��ɾ�����һ����Ч�ڵ㣬Ҳ��Ҫ���⴦��
	 * @param node
	 */
	public void delete(Node node) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node pre = null;
		//��ѯ������������ǰ�ڵ㲻���ڲ�ѯ�ڵ㣬����һ���ڵ㲻Ϊ��
		while (cur != node && cur.next != null) {
			pre = cur;
			cur = cur.next;
		}
		/**
		 * ��ѯ����������ҵ��ˣ���ǰ�ڵ���ڲ�ѯ�ڵ�
		 * ���ɾ��ͷ�ڵ㣬�򷵻ؿյ�ͷ
		 * ���û���ҵ�����ʲô������
		 */
		if (cur == node) {
			if (cur == head) {
				head = null;
				return;
			} else {
				pre.next = cur.next;
			} 
		}
	}
	/**
	 * �Ƿ�����ڵ㣬�����򷵻ص�һ��ƥ��Ľڵ�
	 * @param node
	 * @return
	 */
	public Node contains(Node node) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		while (cur != node && cur.next != null) {
			cur = cur.next;
		}
		return cur == node ? cur : null;
	}
	
	/**
	 * ���ظ�ֵ���ڵĽڵ�
	 * @param value
	 * @return
	 */
	public Node findValue(int value) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		while (cur.value != value && cur.next != null) {
			cur = cur.next;
		}
		return cur.value == value ? cur : null;
	}
}
