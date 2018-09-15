package stackandqueue;

import java.util.Stack;
/**
 * ʵ��һ�������ջ�����Է���ջ����С��Ԫ��
 * Ҫ��pop, push , getMin��ʱ�临�Ӷȶ���O��1��
 * @author Valiant
 * ˼·1��ʹ��һ����Сջ��ͬ���洢��ǰ����Сֵ��stack���minStack���ɶ��
 * ˼·2��ʹ��һ����Сջ��ÿ�θ��¸�С��ֵ��ջ�У�stack��pop��ֵ�������ջ��ֵ���򵯳�minStackֵ
 */
public class StackWithGetMin {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
	
	public static void main(String[] args) {
		StackWithGetMin stackWithGetMin = new StackWithGetMin();
		int[] arr = {3, 4, 5, 1, 2, 1};
		for (int i = 0; i < arr.length; i++) {
			stackWithGetMin.push(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			stackWithGetMin.getMin();
			stackWithGetMin.pop();

		}
	}
	
	public int pop() {
		if (stack.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		minStack.pop();
		return stack.pop();
	}
	
	public void push(Integer number) {
		stack.push(number);
		if(minStack.isEmpty()) {
			minStack.push(number);
		} else {
			minStack.push(minStack.peek() > number ? number : minStack.peek());
		}
	}
	
	public void getMin() {
		System.out.println("the min number is : " + minStack.peek());
	}
}
