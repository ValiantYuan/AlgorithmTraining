package bookcode.marchonoffer.stackandqueue;

import java.util.Stack;

/**
 * 用递归函数和栈操作逆序一个栈
 * @author Valiant
 * 解题关键思想：
 * 正常的pop方法，只能获取到最后入栈的数，为了逆序一个栈，必须能获取到最先入栈的数，所以需要对pop操作进行包装，让stack返回并移出最先入栈的值
 * 
 */
public class ReverseStack {
	
	/**
	 * 获取当前stack的最后一个元素，并移除掉
	 * @param stack
	 * @return
	 */
	public int getAndRemoveLastElement(Stack<Integer> stack) {
		int current = stack.pop();
		//到达最里层循环
		if (stack.empty()) {
			return current;
		} else {
			//通过递归把最后一个数传递到最外层，同时把最底层的数据丢弃掉了
			int last = getAndRemoveLastElement(stack);
			stack.push(current);
			return last;
		}
	}
	
	public void reverseStack(Stack<Integer> stack) {
		if (stack.empty()) {
			return;
		}
		int last = getAndRemoveLastElement(stack);
		reverseStack(stack);
		stack.push(last);
	}
	
	
	public static void main(String[] args) {
		ReverseStack reverseStack = new ReverseStack();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.elementAt(i));
		}
		
		reverseStack.reverseStack(stack);
		
		
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.elementAt(i));
		}
	}
}
