package leetcode.problem.simple.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : yuanqi
 * @since : 2021/1/21
 * 假设返回的数组对中不能有重复的值
 */
public class TwoSum {
    public List<int[]> twoSum(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int left = nums[low], right = nums[high];
            int sum = left + right;
            if (sum < target) {
                while(low < high && nums[low] == left) {
                    low++;
                }
            } else if (sum > target) {
                while (low < high && nums[high] == right) {
                    high--;
                }
            } else {
                result.add(new int[] {low, high});
                while(low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            }
        }
        return result;
    }
}
