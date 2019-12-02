package leetcode.problem.medium.string;

/**
 * @NAME: LongestSharedSubString
 * @USER: valiant
 * @DATE: 2019-09-23
 * @DESCRITION:
 **/
public class LongestSharedSubString {
    public String longestSharedSubString(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        int length1 = str1.length();
        int length2 = str2.length();
        if (length1 * length2 == 0) {
            return null;
        }
        int[][] matrix = new int[length1][length2];
        int maxEndPos = 0;
        int max = 0;
        //两次循环递归遍历
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                //如果两个字符相等，则更新对应matrix的值为公共长度
                if (str1.charAt(i) == str2.charAt(j)) {
                    //如果i或者j是0，即代表第一个字符，则更新最长长度为1
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        //否则，更新最长为上一个位置的值加1
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                        maxEndPos = i;
                    }
                }
            }
        }
        if (max > 0) {
            return str1.substring(maxEndPos - max + 1, maxEndPos + 1);
        }
        return null;
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "ell";
        System.out.println(new LongestSharedSubString().longestSharedSubString(str1,str2));
    }
}
