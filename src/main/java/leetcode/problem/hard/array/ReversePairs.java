package leetcode.problem.hard.array;

/**
 * @ClassName ReversePairs
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 求数组中逆序对个数，运用归并排序时合并两个有序数组进行交换的思想，统计逆序对个数
 * @Author: YuanQi
 * @Date: 2020/4/24
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        return reversePairs(nums, 0 ,nums.length - 1, new int[nums.length]);
    }


    public int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, tmp);
        int rightPairs = reversePairs(nums, mid + 1, right, tmp);
        if (nums[mid] <= nums[left]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = crossPairs(nums, left, mid , right, tmp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int crossPairs(int[] nums, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right ; k++) {
            // 要注意边界条件
            if (i == mid + 1) {
                nums[k] = tmp[j];
                j++;
            } else if (j == right + 1)  {
                nums[k] = tmp[i];
                i++;
            }
            else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                j++;
                count += mid - i + 1;
            }
        }
        return count;
    }
}
