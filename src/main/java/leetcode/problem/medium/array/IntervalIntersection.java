package leetcode.problem.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yuanqi
 * @since : 2021/1/20
 */
public class IntervalIntersection {
    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] intersection = new IntervalIntersection().intervalIntersection(firstList, secondList);
        System.out.println(intersection);
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int first = 0;
        int second = 0;
        while (first < firstList.length && second < secondList.length) {
            int first1 = firstList[first][0],
                first2 = firstList[first][1],
                second1 = secondList[second][0],
                second2 = secondList[second][1];
            if (second2 >= first1 && first2 >= second1) {
                result.add(new int[]{Math.max(first1, second1), Math.min(first2, second2)});
            }
            if (first2 >= second2) {
                second++;
            } else {
                first++;
            }
        }
        return result.toArray(new int[0][]);
    }
}
