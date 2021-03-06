package leetcode.problem.hard.array;

/**
 * @author : yuanqi
 * @since : 2021/2/8
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Trap {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int count = 0;

        /**
         * 双指针法真的妙，那么如何理解双指针法呢？听我来给你捋一捋。（捋的过程和原解中的C++在细节方面的处理是有出入的）
         *
         * 我们先明确几个变量的意思：
         *
         * left_max：左边的最大值，它是从左往右遍历找到的
         * right_max：右边的最大值，它是从右往左遍历找到的
         * left：从左往右处理的当前下标
         * right：从右往左处理的当前下标
         * 定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
         *
         * 定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。
         * （见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）
         *
         * 定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
         *
         *                                    right_max
         *  left_max                             __
         *    __                                |  |
         *   |  |__   __??????????????????????  |  |
         * __|     |__|                       __|  |__
         *         left                      right
         * 对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，
         * 这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果。
         * 所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
         */
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                count += leftMax - height[left];
                left++;
            } else {
                count += rightMax - height[right];
                right--;
            }
        }
        return count;
    }
}
