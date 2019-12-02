package leetcode.explore.interview.primarytest.dynamicplanning;

public class MaxProfit {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		int maxProfit = 0;
		int min = prices[0];
		int max = prices[0];
		for (int i = 1; i < prices.length; i++) {
//			if (prices[i] < min) {
//				maxProfit = max - min;
//				min = prices[i];
//				max = prices[i];
//			} else if (prices[i] > max) {
//				max = prices[i];
//				maxProfit = max - min > maxProfit ? max - min : maxProfit;
//			} 
			if (prices[i] > max) {
				max = prices[i];
				maxProfit = max - min > maxProfit ? max - min : maxProfit;
			} else if (prices[i] < min) {
				min = prices[i];
				max = prices[i];
			}
			
		}
		return maxProfit;
	}
}
