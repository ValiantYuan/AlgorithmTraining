package geektimepractice.sort;

/**
 * 归并排序,时间复杂度很稳定，但是最大的问题就是它不是原地排序，需要申请额外的空间O(n)，每次临时数组的申请和消除就要耗时
 * @author valiant
 * 
 */
public class MergeSort {
	public void mergeSort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	/**
	 * 
	 * @param a
	 * @param start
	 * @param end
	 */
	public void sort(int[] a, int start, int end) {
		if (start == end) {
			return;
		}
		int center = (start + end) / 2;
		sort(a, start, center);
		sort(a, center + 1, end);
		merge(a, start, center, end);
	}

	/**
	 * 
	 * @param a   原数组
	 * @param fps first part start position
	 * @param fpe first part end position, sps = fpe + 1
	 * @param spe second part end position
	 * @return
	 */
	public void merge(int[] a, int fps, int fpe , int spe) {
		int length = spe - fps + 1;
		int[] result = new int[length];
		/**
		 * 把前后两个部分的数组重新排序的结果放入到result数组中
		 */
		for (int i = fps, j = fpe + 1, p = 0; p < length; p++) {
			if (a[i] <= a[j]) {
				result[p] = a[i];
				i++;
			} else {
				result[p] = a[j];
				j++;
			}
		}
		/**
		 * 从result数组复制到a数组中
		 */
		for (int i = 0; i < result.length; i++, fps++) {
			a[fps] = result[i];
		}
	}
}
