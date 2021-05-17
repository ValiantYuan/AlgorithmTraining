package practice;

/**
 * @author : yuanqi
 * @since : 2021/4/21
 * 1.单词a,单词b，希望把单词a转换为单词b，每次只能插入删除或者更新一个字符，求最少需要多少步
 * 2.堆排序
 */
public class Ebay2 {

    public static void main(String[] args) {
        String source = "abcddd";
        String target = "ac";
        System.out.println(new Ebay2().transform(source, target));
    }


    public int transform(String source, String target) {

        int column = source.length();
        int length = target.length();

        int[][] dp = new int[column + 1][length + 1];
        // 如果target长度为0，一定要进过i次插入操作
        for (int i = 1; i <= column; i++) {
            dp[i][0] = i;
        }

        // 如果source长度为0，一定要进过i次删除操作
        for (int i = 1; i <= length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= column; i++) {

            for (int j = 1; j <= length; j++) {
                // 状态转移方程
                // 1.i,j同时增加一位，则比较i和j增加的这一位是否相同
                // 2.i不变，j增加了一位，则需要插入一位
                // 3.j不变，i增加了一位，则需要删除一位
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + source.charAt(i - 1) == source.charAt(j - 1) ? 0 : 1,
                    dp[i][j - 1] + 1),
                    dp[i - 1][j] + 1);
            }
        }
        return dp[column][length];
    }


}
