package leetcode.problem.simple.array;

/**
 * @author : yuanqi
 * @since : 2021/1/19
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit_2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new MaxProfit_2().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int i_notHold = 0;
        int i_hold = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int tmp = i_notHold;
            i_notHold = Math.max(i_notHold, i_hold + prices[i]);
            i_hold = Math.max(i_hold, tmp - prices[i]);
        }
        return i_notHold;
    }
}
