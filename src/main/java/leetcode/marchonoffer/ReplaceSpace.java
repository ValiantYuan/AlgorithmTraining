package leetcode.marchonoffer;

/**
 * @author : yuanqi
 * @since : 2020/9/4
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
