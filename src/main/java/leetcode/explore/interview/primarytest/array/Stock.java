package leetcode.explore.interview.primarytest.array;

/**
 * @ClassName Stock
 * @Description:
 * @Author: YuanQi
 * @Date: 2020/3/6
 */
public class Stock {

    public static void main(String[] args) {
        System.out.println(new Stock().maxProfit(new int[]{7,1,5,3,13,2,4}));
    }
//    public int maxProfit(int[] prices) {
//        int buy = prices[0];
//        int sell = prices[0];
//        int sum = 0;
//        for (int i = 0; i < prices.length; i++) {
//            // 一定要注意buy和sell的价格变化，在遇到更低价时买卖的价格都要变化
//            if (buy < sell && sell > prices[i]) {
//                sum += sell - buy;
//                buy = prices[i];
//                sell = prices[i];
//            }
//            else if (prices[i] >= sell) {
//                sell = prices[i];
//            }
//            else if (prices[i] <= buy) {
//                buy = prices[i];
//                sell = prices[i];
//            }
//        }
//        return sum + (buy <= sell ? sell - buy : 0);
//    }

    public int maxProfit(int[] nums) {


        int buy = nums[0];
        int sell = nums[0];
        int profit = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < buy && buy == sell) {
                buy = nums[i];
                sell = nums[i];
            } else if (nums[i] > sell) {
                sell = nums[i];
            } else {
                profit += sell - buy;
                buy = nums[i];
                sell = nums[i];
            }
        }
        return profit + sell - buy;
    }

    public int maxProfitNew(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length == 0 || prices.length == 1) return profit;
        // 这个方法乍一看有问题，好像会出现重复买卖的问题，例如 2，4，6
        // 4这个价格会计算一次作为买的价格，同时又会计算一次作为卖的价格
        // 但是其实最终的收益还是4
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
