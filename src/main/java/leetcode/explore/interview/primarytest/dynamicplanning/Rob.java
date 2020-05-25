package leetcode.explore.interview.primarytest.dynamicplanning;


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


    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] nums1 = {1, 5, 2, 1, 7};
        int[] nums2 = {1, 5, 5, 1, 7};
        int result1 = getMax1(nums1);
        int result2 = getMax(nums2);
        System.out.println(result1);
        System.out.println(result2);
    }

    static int getMax(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    public static int getMax1(int[] nums) {
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[nums.length - 1];
	}

}
