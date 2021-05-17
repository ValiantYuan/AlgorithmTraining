package leetcode.problem.medium.array;

/**
 * @author : yuanqi
 * @since : 2021/1/20
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class Rob_2 {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2),
            rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int rob = 0;
        int notRob = 0;
        for (int i = start; i <= end; i++) {
            int tmp = notRob;
            notRob = Math.max(notRob, rob);
            rob = Math.max(tmp + nums[i], tmp);
        }
        return Math.max(notRob, rob);
    }
}
