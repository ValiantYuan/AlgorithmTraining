package stackandqueue;

import java.util.Stack;

/**
 * �õݹ麯����ջ��������һ��ջ
 * @author Valiant
 *
 */
public class ReverseStack {
	
	/**
	 * ��ȡ��ǰstack�����һ��Ԫ�أ����Ƴ���
	 * @param stack
	 * @return
	 */
	public int getAndRemoveLastElement(Stack<Integer> stack) {
		int current = stack.pop();
		//���������ѭ��
		if (stack.empty()) {
			return current;
		} else {
			//ͨ���ݹ�����һ�������ݵ�����㣬ͬʱ����ײ�����ݶ�������
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
