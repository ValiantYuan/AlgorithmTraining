package geektimepractice.sort;

public class BubbleSort {
	
	public void bubbleSort(int[] a) {
		int n = a.length;
		//从小到大排序，理论上要进行n次冒泡
		for(int i = 0; i < n; i++) {
			boolean flag = false;
			//每次冒泡都从0开始，但是从a[n - i - 1]到a[n - 1]位已经排序完成，不需要再进行冒泡比较
			for (int j = 0; j < n - i -1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;
				}
			}
			//没有数据交换，提前退出即可
			if (!flag) {
				break;
			}
		}
	}
}
