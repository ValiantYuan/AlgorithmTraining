package leetcode.explore.interview.primarytest.dynamicplanning;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * @author Valiant
 */
public class LongestSubstring {
    public static void main(String[] args) {
        new LongestSubstring().longestSubstring("bbaaacbd", 3);
    }

    public int longestSubstring(String s, int k) {
        if (s.length() < k || s.length() == 0) return 0;
        int[] chars = new int[26];
        //如果这个字符串中的所有出现过的字符都大于等于k，则这个字符是valid
        boolean valid = true;
        for (int i = 0; i < s.length(); i++) chars[s.charAt(i) - 'a']++;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < k && chars[i] > 0) {
                valid = false;
            }
        }
        if (valid) return s.length();
        int start = 0;
        int cur = 0;
        int result = 0;
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        //当前面的循环中的最后一个字符仍然满足>k时，没有计算result值，所以此时要取从start开始的子串进行计算"aabbb"子串变成计算"bbb"子串，而"bbb"子串会计算三个"b"返回为3
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }


}
