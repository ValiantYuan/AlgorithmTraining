package leetcode.dynamicplanning;

/**
 * @author : yuanqi
 * @since : 2020/9/6
 * http://codeforces.com/contest/1105/problem/C
 * 很经典的一道题目，用回溯算法会溢出，采用动态规划则可以通过划分子问题，采用递归
 */
public class ArraysCount {
    static long count = 0;

    // stack overflow
    public static void getArraysCountOld(int cursor, int n, long l, long r, long sum) {
        if (cursor == n) {
            if (sum % 3 == 0)
                count++;
            return;
        }
        for (long j = l; j <= r; j++) {
            sum = sum + j;
            // sum对3取余防止溢出
            getArraysCountOld(cursor + 1, n, l, r, sum % 3);
            sum = sum - j;
        }
    }


    public static long getArraysCount(int n, long l, long r) {
        long[] statistic = getMod3CountInRange(l, r);
        long[] result = new long[3];
        long[] preResult = new long[3];
        copyValue(statistic, result);
        for (int i = 1; i < n; i++) {
            copyValue(result, preResult);
            result[0] = ((preResult[0] * statistic[0]) + (preResult[1] * statistic[2]) + (preResult[2] * statistic[1])) % (1000000000L + 7);
            result[1] = ((preResult[0] * statistic[1]) + (preResult[1] * statistic[0]) + (preResult[2] * statistic[2])) % (1000000000L + 7);
            result[2] = ((preResult[0] * statistic[2]) + (preResult[1] * statistic[1]) + (preResult[2] * statistic[0])) % (1000000000L + 7);
        }
        return result[0];
    }

    private static void copyValue(long[] origin, long[] tar) {
        for (int i = 0; i < tar.length; i++) {
            tar[i] = origin[i];
        }
    }

    public static long[] getMod3CountInRange(long start, long end) {
        long[] counts = new long[3];
        long size = (end - start + 1) / 3;
        for (int i = 0; i < 3; i++) {
            counts[i] = size;
        }
        long temp = start + 3 * size;
        while (temp <= end) {
            counts[(int) (temp % 3)]++;
            temp++;
        }
        return counts;
    }


    public static void main(String[] args) {
//        getArraysCountOld(0, 5, 1, 11, 0);
//        System.out.println(count);
        System.out.println(getArraysCount(9, 9, 99));
    }


}
