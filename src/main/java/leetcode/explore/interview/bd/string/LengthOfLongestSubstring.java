package leetcode.explore.interview.bd.string;

import java.util.HashMap;

/**
 * @NAME: LengthOfLongestSubstring
 * @USER: valiant
 * @DATE: 2019-09-23
 * @DESCRITION: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        //i表示当前窗口的结束位置，j表示当前窗口的起始位置
        for (int i = 0, j = 0; i < s.length(); i++) {
            //如果包含当前的字符，则更新j到j和原字符位置+1中较大的一个值，
            //原因是，j之前的值并没有移除，仍然可能被查找到，如果当前值与窗口外的值重复了，则保持当前窗口起始位置不变
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            //更新当前字符的位置为最新的位置
            map.put(s.charAt(i), i);
            //如果在最后一直没有发生重复，则要取最后一段的长度与最长字符串长度的较大者
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
