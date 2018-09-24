package stackandqueue;

import java.nio.charset.MalformedInputException;
import java.util.Map;
import java.util.Stack;

/**
 * һ����ά������0/1���
 *  0 1 0 1
 *  1 1 1 1
 *  0 1 1 1
 *  ��ȫ����1������Ӿ������
 * @author Valiant
 *
 */
public class BiggestSubRectValue {
	int[][] map;
	
	/**
	 * Ĭ��map����������
	 * @param map
	 * @return
	 */
	public int maxSubRect(int[][] map) {
		/**
		 * java��newһ���������͵��������г�ʼ��Ϊ0�Ĳ����������new�Ķ������飬�򲻻ᣬ���������ᴥ������ĳ�ʼ������һ��jvm����������
		 * jvmʵ���ϲ�����һ���µ�������󣬶����漰������
		 */
		int[] heights = new int[map[0].length];
		int maxSize = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < map.length; i++) {
			
			for (int j = 0; j < map[i].length; j++) {
				heights[j] = map[i][j] == 1 ? heights[j] + 1 : 0;
				//�����ǰ�߶ȴ��ڵ���ջ���ĸ߶ȣ���ѹ��ջ�У�ջ�Ӷ�������������
				//�����ǰ�߶�С��ջ���ĸ߶ȣ������ֱ��ջ��С�ڵ�ǰ�߶�λ�õ��Ӿ���������ֵ
				while (!stack.empty() && heights[stack.peek()] >= heights[j]) {
					int heightPos = stack.pop();
					int endPos = stack.empty() ? -1 : stack.peek();
					int size = heights[heightPos] * (j - 1 - (endPos + 1) + 1);
					maxSize = maxSize >= size ? maxSize : size;
				}
				stack.push(j);
			}
			
			
		}
		while (!stack.empty()) {
			int heightPos = stack.pop();
			int endPos = stack.empty() ? -1 : stack.peek();
			int size = heights[heightPos] * (heights.length - endPos - 1);
			maxSize = maxSize >= size ? maxSize : size;
		}
		return maxSize;
	}
	
	public static void main(String[] args) {
		BiggestSubRectValue biggestSubRectValue = new BiggestSubRectValue();
		 int[][] map = new int[][] {{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
		 System.out.println(biggestSubRectValue.maxSubRect(map));
	}
}
