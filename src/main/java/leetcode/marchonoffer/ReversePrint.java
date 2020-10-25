package leetcode.marchonoffer;

import java.util.Stack;

import basestructure.ListNode;

/**
 * @author : yuanqi
 * @since : 2020/9/4
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
