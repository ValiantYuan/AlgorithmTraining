package leetcode.explore.interview.primarytest.dynamicplanning;

public class ClimbStairs {
//	public int climbStairs(int n) {
//		if(n == 0) return 0;
//		if(n == 1) return 1;
//		if(n == 2) return 2;
//		return climbStairs(n - 1) + climbStairs(n - 2);
//	}
	public int climbStairs(int n) {
        if(n < 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
		int pre2Count = 1;
        int pre1Count = 2;
		int count = 0;
        int k = 3;
		while (k <= n) {
            count = pre1Count + pre2Count;
            pre2Count = pre1Count;
            pre1Count = count; 
            k++;
        }
		return count;
	}
}
