package bookcode.stackandqueue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 有一个整形数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右滑一个位置
 * 实现一个函数：
 * 输入：整形数组arr，窗口大小为w
 * 输出：一个长度为n-w+1的数组res, res[i]表示每一种窗口状态下的最大值
 * 
 * 解题关键思想：
 * 
 * 
 * @author Valiant
 *
 */
public class BiggestNumberArrayThroughWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
		int window = 3;
		int[] result = new BiggestNumberArrayThroughWindow().process(arr, window);
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public int[] process(int[] arr, int w) {
		int[] res = new int[arr.length - w + 1];
		LinkedList<Integer> qmax = new LinkedList<>();
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
				qmax.pollLast();
			}
			qmax.add(i);
			//最大值过期
			if(qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}
			//记录每个窗口的最大值
			if (i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
		

	}
	

}
