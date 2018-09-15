package stackandqueue;

import java.util.Stack;

/**
 * 编写一个类，用两个栈实现队列，实现基本操作
 * @author Valiant
 * 思路：两个栈，一个记录压入，一个逆序记录压入
 * 只有当queue被pop空后，才会将stack中的记录一次性全部push到queue中
 */
public class QueueUseStack {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> queue = new Stack<>();
	/**
	 * 往队列中加入元素
	 * @param number
	 */
	public void add(int number) {
		stack.push(number);
	}
	/**
	 * 取出最早进入队列中的元素
	 * @return
	 */
	public int poll() {
		if (queue.empty() && stack.empty()) {
			throw new RuntimeException("the queue is empty");
		} else if (queue.empty()) {
			while (!stack.empty()) {
				queue.push(stack.pop());
			}
		}
		return queue.pop();
	}
	/**
	 * 获取最早进入队列中的元素的值
	 * @return
	 */
	public int peek() {
		if (queue.empty() && stack.empty()) {
			throw new RuntimeException("the queue is empty");
		} else if (queue.empty()) {
			while (!stack.empty()) {
				queue.push(stack.pop());
			}
		}
		return queue.peek();
	}
}
