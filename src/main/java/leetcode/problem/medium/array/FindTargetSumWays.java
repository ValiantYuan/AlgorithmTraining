package leetcode.problem.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yuanqi
 * @since : 2020/9/8
 */
public class FindTargetSumWays {
    int count = 0;
    Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
//        func(nums, 0, 0, S);
//        return count;
        int sum = 0;
        for (int n : nums) sum += n;
        // 这两种情况，不可能存在合法的子集划分
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        return dpBagAdvance(nums, (sum + S) / 2);

    }

    public void func(int[] nums, int sum, int pos, int s) {
        if (pos == nums.length) {
            if (sum == s) {
                count++;
            }
            return;
        }
        func(nums, sum + nums[pos], pos + 1, s);
        func(nums, sum - nums[pos], pos + 1, s);
    }


    public int dp(int[] nums, int i, int rest) {
        if (i == nums.length) {
            if (rest == 0) {
                return 1;
            }
            return 0;
        }
        String key = i + ":" + rest;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        // i处和为rest的结果等于i+1处和为rest - nums[i]或者rest + nums[i]的和，因为nums[i]可以是正负数
        int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
        map.put(key, result);
        return result;
    }

    /**
     * 用背包问题的思想解决这个问题
     * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/targetsum
     *
     * @param nums 数组
     */
    public int dpBag(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    // 前i个元素和为j的组合个数为前i-1个元素组合为j和j - nums[i - 1]的和，注意nums[i -1]代表第i个数
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    // 当前nums[i - 1]大于j时，只能不放入/选取
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }


    public int dpBagAdvance(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    // 因为压缩成了一维dp，所以要考虑历史记录覆盖问题
                    // 计算前i个数的dp数组时，使用的时前i-1个数的dp数组，如果顺序遍历，dp[j - nums[i - 1]]会被覆盖
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[target];
    }
}
