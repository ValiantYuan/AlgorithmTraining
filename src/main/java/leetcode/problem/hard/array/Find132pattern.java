package leetcode.problem.hard.array;

import java.util.Stack;

/**
 * @author : yuanqi
 * @since : 2020/8/23
 * https://leetcode-cn.com/problems/132-pattern/
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        // stack是一个最小栈，栈顶的元素是比当前值对应的min[i]大的最小值，以使当前值更容易满足比栈中的值大
        Stack<Integer> stack = new Stack<>();
        // 在对位置i进行判断是，左侧比i小的最小的值，可以是i本身，这种情况下，会被跳过处理
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        // 因为min是一个非递增数列，所以
        for (int j = nums.length - 1; j >= 0; j--) {
            // 当nums[j] <= min[j]显然不满足条件，跳过不做处理
            // 其实这里可以把当前元素入栈，但是由于min[j]会非递减变化，所以实际上还会在下一次操作中被pop出来，反而浪费了操作
            if (nums[j] > min[j]) {
                // 对栈pop操作后，对于后续j的值，显然min[j]会递增或者维持不变，考虑两种情况
                // 1. 栈顶的值大于当前min[j]，显然满足了条件
                // 2. 栈顶的值小于当前min[j]，pop出去的值都是比栈顶值小的值，需要继续pop，在这种情况下，也不影响结果
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                //
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                // 如果栈顶值大于等于当前值，
                stack.push(nums[j]);
            }
        }
        return false;
    }


}
