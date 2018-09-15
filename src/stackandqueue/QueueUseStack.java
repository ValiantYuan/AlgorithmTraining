package stackandqueue;

import java.util.Stack;

/**
 * ��дһ���࣬������ջʵ�ֶ��У�ʵ�ֻ�������
 * @author Valiant
 * ˼·������ջ��һ����¼ѹ�룬һ�������¼ѹ��
 * ֻ�е�queue��pop�պ󣬲ŻὫstack�еļ�¼һ����ȫ��push��queue��
 */
public class QueueUseStack {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> queue = new Stack<>();
	/**
	 * �������м���Ԫ��
	 * @param number
	 */
	public void add(int number) {
		stack.push(number);
	}
	/**
	 * ȡ�������������е�Ԫ��
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
	 * ��ȡ�����������е�Ԫ�ص�ֵ
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
