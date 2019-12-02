package leetcode.explore.interview.bytedance.arrayandsort;

import java.util.HashSet;

/**
 * @NAME: LongestConsecutive
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION: 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
 **/
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        //边界条件判断
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        //先将数组中的数都添加到HashSet中
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            //这里判断的是num - 1的值是否在set中，因为如果存在，则num一定会在包含num - 1的数组序列中
            if (!set.contains(num - 1)) {
                int cur = num;
                int curLen = 1;
                //注意自增运算符，写出cur++会报错，因为计算在自增之前
                while (set.contains(++cur)) {
                    curLen++;
                }
                max = Math.max(max, curLen);
            }
        }
        return max;
    }
}
