package stackandqueue;

import java.util.Stack;
/**
 * 实现一个特殊的栈，可以返回栈中最小的元素
 * 要求：pop, push , getMin的时间复杂度都是O（1）
 * @author Valiant
 * 思路1：使用一个最小栈，同步存储当前的最小值，stack多大，minStack就由多大
 * 思路2：使用一个最小栈，每次更新更小的值到栈中，stack中pop的值如果等于栈顶值，则弹出minStack值
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
