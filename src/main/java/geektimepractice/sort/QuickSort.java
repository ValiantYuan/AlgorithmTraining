package geektimepractice.sort;

import java.util.Arrays;

import bookcode.grokkingalgorithms.Chapter4;

/**
 * 快速排序
 * 原地算法，不稳地排序，时间复杂度O(nlogn)
 * @author valiant
 *
 */
public class QuickSort {
	public void quickSort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	/**
	 * 
	 * @param a
	 * @param start 排序区间在数组中的起始位置
	 * @param end 排序区间在数组中的终止位置
	 */
	public void sort(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}
		int pivot = partition(a, start, end);
		sort(a, start, pivot - 1);
		sort(a, pivot + 1, end);
	}
	/**
	 * 返回已经前后分区的快排数字的分区位置
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	public int partition(int[] a, int start , int end) {
		int j = start;
		int tmp = 0;
		/**
		 * 把区间中的最后一个点作为pivot分区点，所以在比较时，值比较到i < end,一共只比较了end - start个数
		 * j记录的是已排序区间中第一个比pivot大的位置值
		 */
		for (int i = start; i < end; i++) {
			//如果当前值比a[pivot]即a[end]小，需要与当前的a[j]交换位置
			if (a[i] < a[end]) {
				tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				j++;
			}
		}
		tmp = a[j];
		a[j] = a[end];
		a[end] = tmp;
		return j;
	}

	public static void main(String[] args) {
		int[] array = {12, 4, 5, 3, 2, 15, 42, 17, 7, 51};
		new QuickSort().quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
