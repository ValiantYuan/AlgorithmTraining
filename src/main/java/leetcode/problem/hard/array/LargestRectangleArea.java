package leetcode.problem.hard.array;

import java.util.Stack;

/**
 * @author : yuanqi
 * @since : 2021/2/20
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 首先我们枚举某一根柱子 ii 作为高 h = \textit{heights}[i]h=heights[i]；
 *
 * 随后我们需要进行向左右两边扩展，使得扩展到的柱子的高度均不小于 h。
 * 换句话说，我们需要找到左右两侧最近的高度小于 hh 的柱子，这样这两根柱子之间（不包括其本身）的所有柱子高度均不小于 hh，并且就是 ii 能够扩展到的最远范围。
 *
 *
 *
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            // 栈顶到栈底逐步变小,找到的是左侧比当前点小的最近值
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            // 栈顶到栈底逐步变小,找到的是右侧比当前点小的最近值
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max((right[i] - left[i] - 1) * heights[i], ans);
        }
        return ans;
    }
}
