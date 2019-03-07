package leetcode.primarytest.array;
/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @author valiant
 *
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
    	int tmp = 0;
    	while (start < end) {
    		tmp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = tmp;
    		start++;
    		end--;
    	}
    }
}
