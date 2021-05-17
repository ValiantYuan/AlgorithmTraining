package practice;

/**
 * @author : yuanqi
 * @since : 2021/3/24
 */
public class Bananas {

    public int getBananas(int[] eats) {


        int[] dp = new int[eats.length];
        dp[eats.length - 1] = eats[eats.length - 1];
        for (int i = eats.length - 2; i >= 0; i--) {
            int addOn = Math.min(dp[i + 1], eats[i] * 2);
            if (addOn > dp[i + 1]) {
                dp[i + 1] = addOn;
            }
            dp[i] = dp[i + 1] + addOn;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] eats = {10, 3, 8, 0 , 2, 0, 7};
        System.out.println(new Bananas().getBananas(eats));
    }
}
