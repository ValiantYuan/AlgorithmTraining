package leetcode.problem.simple.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : yuanqi
 * @since : 2021/1/21
 * 假设返回的数组中不能有重复的值
 */
public class NSum {
    public List<List<Integer>> nSum(int[] nums, int start, int end, int n, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 2) {
            int low = start;
            int high = end;
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
                    List<Integer> list = new ArrayList<>();
                    list.add(low);
                    list.add(high);
                    result.add(list);
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
        for (int i = start; i <= end; i++) {
            if (nums[i] > target) {

            }
            int tmp = nums[i];
            while(i < end && nums[i] == tmp) {
                i++;
            }
        }
        return null;

    }


    public List<int[]> nSum(int[] nums, int n, int target) {
        Arrays.sort(nums);
        return null;
    }
}
