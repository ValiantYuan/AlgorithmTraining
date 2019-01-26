package bookcode.stackandqueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
/**
 * 递归和非递归方法实现汉诺塔，从左到右移动，不能直接从左到 右或者从右到左
 * @author Valiant
 *
 * 解题关键思想：
 */
public class Hanno {
	private final String LEFT = "letf";
	private final String MID = "mid";
	private final String RIGHT = "right";
	
	public static void main(String[] args) {
		int num = 5;
		String from = "left";
		String to = "right";
		System.out.println(new Hanno().haniProblem2(num, from, to));
		
	}
	
	public int haniProblem(int num, String from, String to) {
		if (num < 1) {
			return 0;
		}
		return move(num, from, to);
	}
	
	
	/**
	 * 递归的方法解决汉诺塔问题
	 * @param num
	 * @param from
	 * @param to
	 * @return
	 */
	public int move(int num, String from, String to) {
		if(num == 1) {
			if(from.equals(MID) || to.equals(MID)) {
				System.out.println("Move 1 from " + from + " to " + to);
				return 1;
			} else {
				System.out.println("Move 1 form " + from + " to " + MID);
				System.out.println("Move 1 form " + MID + " to " + to);
				return 2;
			} 
		} else if (from.equals(MID) || to.equals(MID)) {
			String other = (from.equals(LEFT) || to.equals(LEFT)) ? RIGHT : LEFT;
			int part1 = move(num - 1, from, other);
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + to);
			int part3 = move(num - 1, other, from);
			return part1 + part2 + part3;
		} else {
			int part1 = move(num - 1, from, to);
			int part2 = 1;
			System.out.println("Move " + num + " from " + from + " to " + MID);
			int part3 = move(num - 1, to, from);
			int part4 = 1;
			System.out.println("Move " + num + " from " + MID + " to " + to);
			int part5 = move(num - 1, from, to);
			return part1 + part2 + part3 + part4 + part5;
		}
	}
	
	/**
	 * 非递归方法解决
	 * @param num
	 * @param from
	 * @param to
	 * @return
	 */
	public int haniProblem2(int num, String from, String to) {
		Stack<Integer> lStack = new Stack<>();
		Stack<Integer> mStack = new Stack<>();
		Stack<Integer> rStack = new Stack<>();
		lStack.push(Integer.MAX_VALUE);
		mStack.push(Integer.MAX_VALUE);
		rStack.push(Integer.MAX_VALUE);
		
		for (int i = num; i > 0; i--) {
			lStack.push(i);
		}
		Action[] record = {Action.No};
		int step = 0;
		while (rStack.size() != num + 1) {
			step += fromStackToStack(record, Action.LToM, Action.MToL, mStack, lStack, MID, LEFT);
			step += fromStackToStack(record, Action.MToL, Action.LToM, lStack, mStack, LEFT, MID);
			step += fromStackToStack(record, Action.MToR, Action.RToM, rStack, mStack, RIGHT, MID);
			step += fromStackToStack(record, Action.RToM, Action.MToR, mStack, rStack, MID, RIGHT);
		}
		return step;
	}
	
	/**
	 * 
	 * @param record 注意，这里如果仅适用Action ,是无法改变record的值的，因为传入的是Action类的指针的值，修改函数中record的值，并不会改变函数外record指针的值，所以依然会指向Action.No
	 * @param preNoAct 不能作为前项的动作
	 * @param nowAct 当前执行的动作
	 * @param fromStack 原始栈
	 * @param toStack 目标栈
	 * @param from 其实位置
	 * @param to 目标位置
	 * @return
	 */
	public static int  fromStackToStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fromStack,
			Stack<Integer> toStack, String from, String to) {
		/**
		 * 两个原则：
		 * 1.互逆的过程不能相邻发生
		 * 2.进栈的要求是小值在大值上面
		 * 
		 */
		if (record[0] != preNoAct && fromStack.peek() < toStack.peek()) {
			toStack.push(fromStack.pop());
			System.out.println("Move " + toStack.peek() + " from " + from + " to " + to);
			record[0] = nowAct;
			return 1;
		}
		return 0;
	}
}

enum Action {
	No, LToM, MToL, MToR, RToM
}

