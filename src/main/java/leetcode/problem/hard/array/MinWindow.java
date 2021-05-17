package leetcode.problem.hard.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yuanqi
 * @since : 2021/1/18
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinWindow().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        // 初始化map
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0 , end = Integer.MAX_VALUE;
        while(right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (tMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(tMap.get(c))) {
                    valid++;
                }
            }
            while (tMap.size() == valid && left <= right) {
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                c = s.charAt(left);
                if (tMap.get(c) != null) {
                    if (windowMap.get(c).equals(tMap.get(c))) {
                        valid--;
                    }
                    windowMap.put(c, windowMap.get(c) - 1);
                }
                left++;
            }

        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

}
