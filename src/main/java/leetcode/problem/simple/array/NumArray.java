package leetcode.problem.simple.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yuanqi
 * @since : 2021/3/1
 */
public class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }

    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
