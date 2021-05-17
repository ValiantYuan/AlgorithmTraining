package leetcode.problem.simple.array;

/**
 * @author : yuanqi
 * @since : 2021/1/19
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new MaxProfit().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int i_notHold = 0;
        int i_hold = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            i_notHold = Math.max(i_notHold, i_hold + prices[i]);
            i_hold = Math.max(i_hold, -prices[i]);
        }
        return i_notHold;
    }
}
