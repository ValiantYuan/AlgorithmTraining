package leetcode.explore.interview.primarytest.linkedlist;

import basestructure.ListNode;

/**
 * @NAME: IsPalindrome
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION:
 **/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        //此处为测试案例特殊处理，
        if (head == null) {
            return true;
        }
        //首先获取链表后半部分的起始位置
        //cur是单数指针，fast是双数指针
        ListNode cur = head;
        ListNode fast = head.next;

        while(fast != null) {
            //fast是最后一个双数位置，cur则起始在下一位
            if(fast.next == null) {
                cur = cur.next;
                break;
            } else if (fast.next.next != null){
                //fast后两个位置不为空，循环继续
                fast = fast.next.next;
                cur = cur.next;
            } else {
                //fast后一个位置为最后一个节点,cur则需要跨越中间值
                cur = cur.next.next;
                break;
            }
        }
        //翻转第二部分链表
        cur = reverse(cur);
        //第二次遍历的头节点
        ListNode secCur = head;
        while (cur != null) {
            if (cur.val != secCur.val) {
                return false;
            }
            cur = cur.next;
            secCur = secCur.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
