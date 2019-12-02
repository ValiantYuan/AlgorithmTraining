package leetcode.problem.medium.string;

/**
 * @NAME: LongestPalindrome
 * @USER: valiant
 * @DATE: 2019-09-23
 * @DESCRITION:
 **/
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        int length = s.length();
        if (length == 0) {
            return "";
        }
        String reverse = new StringBuilder(s).reverse().toString();
        int[][] matrix = new int[length][length];
        int maxEndPos = 0;
        int max = 0;
        //两次循环递归遍历
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                //如果两个字符相等，则更新对应matrix的值为公共长度
                if (s.charAt(i) == reverse.charAt(j)) {
                    //如果i或者j是0，即代表第一个字符，则更新最长长度为1
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        //否则，更新最长为上一个位置的值加1
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                    if (matrix[i][j] > max) {
                        //翻转字符串前，当前j在字符串中的位置
                        int beforeReverse = length - 1 - j;
                        //如果j翻转前的位置加上当前回文长度等于i，则表示是回文字符串
                        if (beforeReverse + matrix[i][j] - 1 == i) {
                            max = matrix[i][j];
                            maxEndPos = i;
                        }
                    }
                }
            }
        }
        if (max > 0) {
            return s.substring(maxEndPos - max + 1, maxEndPos + 1);
        }
        return null;
    }
}
