package leetcode.intermidiate.dynamicplanning;

/**
 * @NAME: LengthOfLIS
 * @USER: valiant
 * @DATE: 2019-09-30
 * @DESCRITION:
 **/
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        //end[i]用来表示长度为i+1的子串的结尾的值，显然end[i]是递增数组
        int[] end = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            end[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < length; i++) {
            int low = 0;
            int high = max;
            //二分查找到第一个大于num[i]的位置low
            //max代表着当前子序列的最大长度
            //二分查找到low值为大于nums[i]的最小值，进行替换，如果low值此时等于max，则代表出现了新的长度，max自增
            while(low < high) {
                int mid = low + (high - low) / 2;
                if (nums[i] <= end[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            //low处的值更新为nums[i]，如果low等于最大长度，则表示当前最大长度增长了1位
            end[low] = nums[i];
            if (low == max) {
                max++;
            }
        }
        return max;
    }
}
