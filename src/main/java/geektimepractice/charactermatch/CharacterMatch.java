package geektimepractice.charactermatch;

import sun.nio.cs.ext.IBM037;

/**
 * 
 * @author Valiant
 *
 */
public class CharacterMatch {
	private static final int SIZE = 256;
	/**
	 * 
	 * @param origin	Դ�ַ���
	 * @param model		ƥ��ģʽ��
	 * @return			ƥ�书�ܷ��ص�һ���ַ���Դ�ַ����е�λ�ã�ƥ��ʧ�ܷ��� -1
	 */
	public int bm(char[] origin, char[] model) {
		int n = origin.length;
		int m = model.length;
		if (m > n) {
			return -1;
		}
		
		//�������ַ���ϣ��
		int[] bc = new int[SIZE];
		generateBC(model, bc);
		
		//����ģʽ���е���󹫹��ִ�
		int[] suffix = new int[m];
		boolean[] prefix = new boolean[m];
		generateGS(model, suffix, prefix);
		
		
		int i = 0; //������ģʽ�������λ��
		while (i <= n - m) {
			int j;
			//ģʽ�����ִ��Ӻ���ǰƥ��,�˳�ѭ��ʱjλ���ַ���ģʽ���е�λ��
			for (j = m - 1; j >= 0; j--) {
				if (origin[i + j] != model[j]) {
					break;
				}
			}
			if (j == -1) {
				return i; //ƥ��ɹ������ص�һ���ַ���λ��
			}
			/**
			 * ƥ�䲻�ɹ���Ҫ�Ƚ��ɻ��ַ�����ͺú�׺����������ƶ����ȣ�ȡ���нϴ��һ��
			 */
			int x = j - bc[(int)origin[i + j]];
			int y = 0;
			//���һ���ַ���û��ƥ��ʱ��j = m -1,��û�кú�׺����j < m - 1,˵�����ٴ��ڳ���λ1�ĺú�׺
			if (j < m - 1) {
				y = move(j, m , suffix, prefix);
			}
			i += Math.max(x, y);
		}
		return -1;
	}

	/**
	 * 
	 * @param j			���ַ���λ��
	 * @param m			ģʽ�ĳ���
	 * @param suffix	��׺����
	 * @param prefix	ǰ׺����
	 * @return
	 */
	public int move(int j, int m, int[] suffix, boolean[] prefix) {
		//�ú�׺�ĳ���
		int k = m - 1 - j;
		//���suffix[k] != -1, ��˵����ģʽ������ǰ׺�ִ���ú�׺�غϣ���Ӧ�ú���
		if (suffix[k] != -1) {
			return j + 1 - suffix[k];
		}
		for (int r = j + 2; r <= m - 1; r++) {
			if (prefix[m - r] == true) {
				return r;
			}
		}
		return m;
	}
	
	
	/**
	 * ����ģʽ���������н�������ASCII���е�ֵ����¼ģʽ��ÿ����ֵ���ֵ�λ��
	 * @param model	ģʽ��
	 * @param bc	��ֵλ������
	 */
	private void generateBC(char[] model, int[] bc) {
		for (int i = 0; i < bc.length; i++) {
			bc[i] = -1;
		}
		for (int i = 0; i < model.length; i++) {
			int ascii = (int)model[i];
			bc[ascii] = i;
		}
	}
	
	/**
	 * ��ģʽ�����з�������bm�㷨�ú�׺����ʹ��
	 * @param model    	ģʽ��
	 * @param length	ģʽ������
	 * @param suffix	������ʾǰ׺�ִ�����k��ʼλ�õ�����
	 * @param prefix    ������ʾ����Ϊk��ģʽǰ׺�Ӵ��Ƿ����׺�ִ�ƥ��
	 */
	private void generateGS(char[] model, int[] suffix, boolean[] prefix) {
		int length = model.length;
		//��ʼ��
		for (int i = 0; i < length; i++) {
			suffix[i] = -1;
			prefix[i] = false;
		}
		//����Ƚ�ģʽ�������λ��Ϊj��ǰ׺�Ӵ���ģʽ��,�ҳ���󹫹��Ӵ�
		for (int i = 0; i < length; i++) {
			int j = i; //ǰ׺�Ӵ������λ��
			int k = 0; //�����Ӵ��ĳ���
			while (j >= 0 && model[j] == model[length - 1 - k]) {
				j--;
				k++;
				suffix[k] = j + 1; //�����Ӵ�����ģʽ�е���ʼ�±꣬��Ϊj--�����������Դ˴�Ҫдj + 1
			}
			//��j = -1ʱ������ǰ׺�Ӵ���ģʽ�еĺ�׺�Ӵ�ƥ�����ˣ���˼�¼prefix[k]Ϊtrue��ǰ׺�Ӵ��빫���Ӵ����������ֻ�е�û�й����Ӵ����ںú�׺ʱ���Żῼ��ǰ׺�Ӵ���ú�׺�����غϵ����
			if (j == -1) {
				prefix[k] = true;
			}
		}
	}


	/**
	 * ʧЧ����
	 * @param b
	 * @param m
	 * @return
	 */
	private static int[] getNexts(char[] b, int m) {
		int[] next = new int[m];
		//���Ӵ�����Ϊ1ʱ���������Ӵ���ֱ�Ӹ�ֵΪ-1
		int k = -1;
		next[0] = -1;
		for (int i = 1; i < m; i++) {
			//����Ӵ���������һ�������ӵ�ֵ�����׺�Ӵ�ƥ���ǰ׺�Ӵ��ĺ�һλ��ͬ����ݹ��жϴγ�ƥ���Ӵ��Ƿ��������������γ�ƥ���Ӵ������Ը����ƥ���Ӵ���next[k]��������λ��������ջ����޷���λ��kֵ����Ϊ-1����û�п���ƥ����Ӵ�
			while(k > 0 && b[i] != b[k + 1]) {
				k = next[k];
			}
			//����Ӵ���������һ�������ӵ�ֵ�����׺�Ӵ�ƥ���ǰ׺�Ӵ��ĺ�һλ��ͬ����ƥ������׺�Ӵ����ȼ�һ��ƥ���ǰ׺�Ӵ���λ�ú���һλ����k++
			if (b[i] == b[k + 1]) {
				k++;
			}
			next[i] = k;
		}
		return next;
	}
	
	public static int kmp(char[] a, int n, char[] b, int m) {
		int[] next = getNexts(b, m);
		int j = 0;
		for (int i = 0; i < n; i++) {
			//������ƥ���ֵʱ����j != 0ʱ�����ݺ�ǰ׺�ĳ���j - 1��������ģʽ������һ����ʼ�Ƚϵ�λ��j = next[j - 1] + 1����next[]Ϊ-1ʱ������ģʽ�������ƶ�����ǰi��λ�ý���ƥ��
			while(j > 0 && a[i] != b[j]) {
				j = next[j - 1] + 1;
			}
			//��ǰ�Ƚ���ͬʱ��ģʽ���������������ƶ�һλ
			if (a[i] == b[j]) {
				//�����������Ӵ�����ʱ�������Ӵ��������е���ʼλ��
				if (j == m - 1) {
					return i - m + 1;
				}
				j++;
			}

		}
		return -1;
	}
}
