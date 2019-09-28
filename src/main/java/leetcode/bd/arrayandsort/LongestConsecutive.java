package leetcode.bd.arrayandsort;

import java.util.HashSet;

/**
 * @NAME: LongestConsecutive
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION:
 **/
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
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
