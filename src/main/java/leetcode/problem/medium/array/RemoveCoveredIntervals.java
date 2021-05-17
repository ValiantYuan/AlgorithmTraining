package leetcode.problem.medium.array;

import java.util.Arrays;

/**
 * @author : yuanqi
 * @since : 2021/1/20
 * https://leetcode-cn.com/problems/remove-covered-intervals/
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        // 起点从小到大排序，起点相同，终点从大到小排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int left = intervals[0][0], right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            /**
             *  ---------
             *  ----
             *  类似这样的覆盖，则消除interval
             */
            if (interval[0] >= left && interval[1] <= right) {
                res++;
            }

            /**
             * ---------
             *  ----------
             *  类似这样的，则合并区间
             */
            else if (interval[0] <= right && interval[1] >= right) {
                right = interval[1];
            }
            /**
             * ------
             *        ------
             * 类似这样的，则更新起点和终点
             */
            else if (interval[0] > right) {
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length - res;
    }
}
