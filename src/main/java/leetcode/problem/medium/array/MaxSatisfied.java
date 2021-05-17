package leetcode.problem.medium.array;

/**
 * @author : yuanqi
 * @since : 2021/2/26
 */
public class MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int addon = 0;
        for (int i = 0; i < X; i++) {
            addon += customers[i] * grumpy[i];
        }
        int maxAddon = addon;
        for (int i = X; i < customers.length; i++) {
            addon = addon - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxAddon = Math.max(maxAddon, addon);
        }
        return sum + maxAddon;
    }
}
