package leetcode.dynamicplanning;

/**
 * @author : yuanqi
 * @since : 2020/9/6
 */
public class GetCoins {
    public static int minCount(int target, int[] coins) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= target; i++) {
            for (int coin: coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }

    public static void main(String[] args) {
        System.out.println(minCount(15,new int[]{1,5,6}));
    }

}
