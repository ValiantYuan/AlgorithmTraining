package leetcode.marchonoffer;

/**
 * @author : yuanqi
 * @since : 2020/9/4
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            // 一直交换到当前下标与数值相同，代表着当前下标处理完成
            while (nums[i] != i) {
                // 有相同的数值
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 与当前数值下标的数交换
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
