package geektimepractice.sort;

public class BubbleSort {
	
	public void bubbleSort(int[] a) {
		int n = a.length;
		//��С��������������Ҫ����n��ð��
		for(int i = 0; i < n; i++) {
			boolean flag = false;
			//ÿ��ð�ݶ���0��ʼ�����Ǵ�a[n - i - 1]��a[n - 1]λ�Ѿ�������ɣ�����Ҫ�ٽ���ð�ݱȽ�
			for (int j = 0; j < n - i -1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;
				}
			}
			//û�����ݽ�������ǰ�˳�����
			if (!flag) {
				break;
			}
		}
	}
}
