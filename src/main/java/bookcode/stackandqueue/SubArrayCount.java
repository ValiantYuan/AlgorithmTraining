package bookcode.stackandqueue;

import java.awt.image.RescaleOp;
import java.util.LinkedList;

/**
 * 一个数组中，最大值减去最小值小于等于指定数值的子数组的个数
 * @author Valiant
 * 思路：遍历数组,设置记录当前子数组最大值和最小值的两个双向链表qmax,qmin， 
 * qmax的表头始终指向当前子数组的最大值，表头后记录的是比当前最大值小的，位置更靠后的值，按从表头往后的数据依次减小。
 * 当遍历某一值，大于表头值时，则将其加到表头，如果大于等于表尾的值时，则弹出表尾的值继续比较，直至遇到比它大的值或者表尾空，加到表尾。
 * qmin原理同上。
 * 
 * 当qmax - qmin <= number时，当前位置i后移一位
 * 当qmax - qmin > number时, 子数组起始位置j为起点的子数组的数目位i - 1 - j + 1 = i - j
 * 根据当前子数组起始位置j，判断qmax和qmin的头部是否过期，过期则弹出
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
