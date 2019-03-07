package leetcode.primarytest.dynamicplanning;

public class Rob {
	public int rob(int[] nums) {
		int notRob = 0;
		int rob = 0;
		int curRob;
		for (int i = 0; i < nums.length; i++) {
			curRob = notRob + nums[i];
			notRob = Math.max(notRob, rob);
			rob = curRob;
		}
		return Math.max(rob, notRob);
	}
}
