package geektimepractice.sort;

public class InsertSort {
	public void insertSort(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			//后面再进行第一次元素后移时，会覆盖掉a[i]中的值，所以要先把a[i]的值保存下来
			int value = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				//已排序部分与当前a[i]进行倒叙比较，如果value值小于当前比较的a[j]，则a[j]需要往后移动一位，
				//当比较是等于或者小于时，则再a[j]后的位置插入value值，这样操作保证了稳定性
				if (value < a[j]) {
					a[j + 1] = a[j];
				} else {
					break;
				}
			}
			a[j + 1] = value;
		}
	}
}
