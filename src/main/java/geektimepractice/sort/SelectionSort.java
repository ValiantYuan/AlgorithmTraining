package geektimepractice.sort;

/**
 * 
 * @author valiant
 *
 */
public class SelectionSort {
	public void selectionSort(int[] a) {
		//从位置0开始遍历整个数组
		for (int i = 0; i < a.length; i++) {
			int min = i;
			//认为数组被分为两个部分，i之前是已排序部分，从i开始往后进行比较，获取剩余未排序记录的最小值
			for (int j = i + 1; j < a.length; j++) {
				if (a[j - 1] > a[j]) {
					min = j;
				}
			}
			int tmp = a[i];
			a[i] = a[min];
			a[min] = tmp;
		}
	}


}
