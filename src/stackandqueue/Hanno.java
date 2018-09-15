package stackandqueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
/**
 * �ݹ�ͷǵݹ鷽��ʵ�ֺ�ŵ�����������ƶ�������ֱ�Ӵ��� �һ��ߴ��ҵ���
 * @author Valiant
 *
 * ����ؼ�˼�룺
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
	 * @param record ע�⣬�������������Action ,���޷��ı�record��ֵ�ģ���Ϊ�������Action���ָ���ֵ���޸ĺ�����record��ֵ��������ı亯����recordָ���ֵ��������Ȼ��ָ��Action.No
	 * @param preNoAct ������Ϊǰ��Ķ���
	 * @param nowAct ��ǰִ�еĶ���
	 * @param fromStack ԭʼջ
	 * @param toStack Ŀ��ջ
	 * @param from ��ʵλ��
	 * @param to Ŀ��λ��
	 * @return
	 */
	public static int  fromStackToStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fromStack,
			Stack<Integer> toStack, String from, String to) {
		/**
		 * ����ԭ��
		 * 1.����Ĺ��̲������ڷ���
		 * 2.��ջ��Ҫ����Сֵ�ڴ�ֵ����
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

