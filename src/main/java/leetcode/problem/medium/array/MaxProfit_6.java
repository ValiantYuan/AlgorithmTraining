package leetcode.problem.medium.array;

/**
 * @author : yuanqi
 * @since : 2021/1/19
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 */
public class MaxProfit_6 {
    public int maxProfit(int[] prices, int fee) {
        int i_notHold = 0;
        int i_hold = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            int tmp = i_notHold;
            i_notHold = Math.max(i_notHold, i_hold + prices[i] - fee);
            i_hold = Math.max(i_hold, tmp - prices[i]);
        }
        return i_notHold;
    }
}
