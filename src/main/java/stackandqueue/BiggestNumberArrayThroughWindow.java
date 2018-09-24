package stackandqueue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ��һ����������arr��һ����СΪw�Ĵ��ڴ����������߻������ұߣ�����ÿ�����һ�һ��λ��
 * ʵ��һ��������
 * ���룺��������arr�����ڴ�СΪw
 * �����һ������Ϊn-w+1������res, res[i]��ʾÿһ�ִ���״̬�µ����ֵ
 * 
 * ����ؼ�˼�룺
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
			//���ֵ����
			if(qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}
			//��¼ÿ�����ڵ����ֵ
			if (i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
		

	}
	

}