package leetcode.explore.interview.bytedance.arrayandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @NAME: Merge
 * @USER: valiant
 * @DATE: 2019-09-30
 * @DESCRITION:
 **/
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null && intervals.length == 0) {
            return result.toArray(new int[0][]);
        }
        //对二维数组按照第一位数字排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        //遍历二维数组
        while(i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //如果当前i的上限大于i+1的下限，则合并数组
            while (i < (intervals.length - 1) && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            i++;
            //添加合并后的数组到结果集中
            result.add(new int[] {left, right});
        }
        return result.toArray(new int[0][]);
    }
}
