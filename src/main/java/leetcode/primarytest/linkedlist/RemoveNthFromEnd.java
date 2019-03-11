package leetcode.primarytest.linkedlist;

import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 * @author Valiant
 *
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (n <= 0) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
    	while(n-- > 0) {
    		if (fast == null) return head;
        	fast = fast.next;
        	
        }
    	if (fast == null && n == 1) return null;
    	while(fast != null) {
    		fast = fast.next;
    		prev = slow;
    		slow = slow.next;
    	}
    	if (prev == null) {
    		//注意这里的head是方法内的局部变量，不能直接使用head = head.next,出来方法后就无效了,但是由于有返回值，可以进行赋值
//    		head.val = head.next.val;
//    		head.next = head.next.next;
    		head = head.next;
    	} else {
    		prev.next = slow.next;
    	}
    	return head;
    }
}
