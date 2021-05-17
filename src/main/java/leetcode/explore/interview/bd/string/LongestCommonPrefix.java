package leetcode.explore.interview.bd.string;

/**
 * @NAME: LongestCommonPrefix
 * @USER: valiant
 * @DATE: 2019-09-23
 * @DESCRITION: 最长公共前缀
 **/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder("");
        int count = strs.length;
        if (strs == null || count == 0) return result.toString();
        int minLength = Integer.MAX_VALUE;
        //找到最短字符串的长度
        for (int i = 0; i < count; i++) {
            if (strs[i].length() < minLength) minLength = strs[i].length();
        }
        //比较每一个字符串当前位置的值是否相等
        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < count; j++) {
                //不相等则返回结果
                if (strs[j].charAt(i) != strs[0].charAt(i)) return result.toString();
            }
            //相等则添加到结果中
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }
}
