package leetcode.problem.hard.array;

/**
 * @author : yuanqi
 * @since : 2021/1/19
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 */
public class MaxProfit_4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max_k = Math.min(k, prices.length / 2);
        int[][][] dp = new int[prices.length][max_k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int t = 1; t <= max_k; t++) {
                if (i - 1 == -1) {
                    dp[i][t][0] = 0;
                    dp[i][t][1] = -prices[i];
                } else {
                    dp[i][t][0] = Math.max(dp[i - 1][t][0], dp[i - 1][t][1] + prices[i]);
                    dp[i][t][1] = Math.max(dp[i - 1][t][1], dp[i - 1][t - 1][0] - prices[i]);
                }

            }
        }
        return dp[prices.length - 1][max_k][0];
    }
}
