package bookcode.stackandqueue;

import java.awt.image.RescaleOp;
import java.util.LinkedList;

/**
 * һ�������У����ֵ��ȥ��СֵС�ڵ���ָ����ֵ��������ĸ���
 * @author Valiant
 * ˼·����������,���ü�¼��ǰ���������ֵ����Сֵ������˫������qmax,qmin�� 
 * qmax�ı�ͷʼ��ָ��ǰ����������ֵ����ͷ���¼���Ǳȵ�ǰ���ֵС�ģ�λ�ø������ֵ�����ӱ�ͷ������������μ�С��
 * ������ĳһֵ�����ڱ�ͷֵʱ������ӵ���ͷ��������ڵ��ڱ�β��ֵʱ���򵯳���β��ֵ�����Ƚϣ�ֱ�������������ֵ���߱�β�գ��ӵ���β��
 * qminԭ��ͬ�ϡ�
 * 
 * ��qmax - qmin <= numberʱ����ǰλ��i����һλ
 * ��qmax - qmin > numberʱ, ��������ʼλ��jΪ�������������Ŀλi - 1 - j + 1 = i - j
 * ���ݵ�ǰ��������ʼλ��j���ж�qmax��qmin��ͷ���Ƿ���ڣ������򵯳�
 */
public class SubArrayCount {
	private final int[] array;
	private final int number;
	
	
	public SubArrayCount(int[] array, int number) {
		super();
		this.array = array;
		this.number = number;
	}
	
	public int getSubArrayNumber() {
		int count = 0;
		int startPos = 0;
		int endPos = 0;
		LinkedList<Integer> qmax = new LinkedList<>();
		LinkedList<Integer> qmin = new LinkedList<>();

		while (startPos < array.length) {
			while (endPos < array.length) {
				while (!qmin.isEmpty() && array[qmin.peekLast()] >= array[endPos] ) {
					qmin.pollLast();
				}
				qmin.addLast(endPos);
				while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[endPos]) {
					qmax.pollLast();
				}
				qmax.addLast(endPos);
				if (array[qmax.peekFirst()] - array[qmin.peekFirst()] > number) {
					break;
				}
				endPos++;
			}
			count += endPos - startPos;
			if (qmax.peekFirst() == startPos) {
				qmax.pollFirst();
			}
			if (qmin.peekFirst() == startPos) {
				qmin.pollFirst();
			}
			startPos++;
		}
		return count;
	}
}
