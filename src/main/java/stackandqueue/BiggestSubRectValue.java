package stackandqueue;

import java.nio.charset.MalformedInputException;
import java.util.Map;
import java.util.Stack;

/**
 * 一个二维矩阵由0/1组成
 *  0 1 0 1
 *  1 1 1 1
 *  0 1 1 1
 *  求全部是1的最大子矩阵面积
 * @author Valiant
 *
 */
public class BiggestSubRectValue {
	int[][] map;
	
	/**
	 * 默认map已满足条件
	 * @param map
	 * @return
	 */
	public int maxSubRect(int[][] map) {
		/**
		 * java中new一个基本类型的数组会进行初始化为0的操作，如果是new的对象数组，则不会，甚至都不会触发对象的初始化，这一点jvm书中有描述
		 * jvm实际上产生了一个新的数组对象，而不涉及对象本身
		 */
		int[] heights = new int[map[0].length];
		int maxSize = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < map.length; i++) {
			
			for (int j = 0; j < map[i].length; j++) {
				heights[j] = map[i][j] == 1 ? heights[j] + 1 : 0;
				//如果当前高度大于等于栈顶的高度，则压入栈中，栈从顶到底依次增大
				//如果当前高度小于栈顶的高度，则计算直到栈中小于当前高度位置的子矩阵面积最大值
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
