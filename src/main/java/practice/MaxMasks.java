package practice;

/**
 * @author : yuanqi
 * @since : 2021/4/1
 */
public class MaxMasks {
    public int getMaxMasks(int n, int[] times, int[] masks, int testTime) {
        int[][] dp = new int[n + 1][testTime + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= testTime; j++) {
                if (j < times[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - times[i - 1]] + masks[i - 1]);
                }
            }
        }
        System.out.println(dp);
        return -1;
    }

    public static void main(String[] args) {
        new MaxMasks().getMaxMasks(4, new int[]{2, 3, 5, 8}, new int[]{1, 2, 4, 5}, 10);
    }

}
