package geektimepractice.sort;

public class InsertSort {
	public void insertSort(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			//�����ٽ��е�һ��Ԫ�غ���ʱ���Ḳ�ǵ�a[i]�е�ֵ������Ҫ�Ȱ�a[i]��ֵ��������
			int value = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				//�����򲿷��뵱ǰa[i]���е���Ƚϣ����valueֵС�ڵ�ǰ�Ƚϵ�a[j]����a[j]��Ҫ�����ƶ�һλ��
				//���Ƚ��ǵ��ڻ���С��ʱ������a[j]���λ�ò���valueֵ������������֤���ȶ���
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
