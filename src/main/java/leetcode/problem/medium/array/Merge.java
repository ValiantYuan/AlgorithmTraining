package leetcode.problem.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : yuanqi
 * @since : 2021/1/20
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return result.toArray(new int[0][]);
        }
        //对二维数组按照第一位数字排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] <= right) {
            } else if (interval[0] <= right) {
                right = interval[1];
            } else {
                result.add(new int[] {left, right});
                left = interval[0];
                right = interval[1];
            }
        }
        result.add(new int[] {left, right});
        return result.toArray(new int[0][]);
    }
}
