package leetcode.explore.interview.primarytest.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MoveZeros
 * @Description: https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/28/
 * @Author: YuanQi
 * @Date: 2020/3/11
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) queue.offer(i);
        }
        if (queue.isEmpty()) return;
        int zeroNums = queue.size();
        int moveSteps = 0;
        int curZeroPos = queue.poll();
        for (int i = 0; i < nums.length; i++) {
            if (i < curZeroPos && moveSteps > 0) {
                nums[i - moveSteps] = nums[i];
            } else if (i == curZeroPos) {
                moveSteps++;
                if (!queue.isEmpty()) {
                    curZeroPos = queue.poll();
                }
            } else if (i > curZeroPos && queue.isEmpty()) {
                nums[i - moveSteps] = nums[i];
            }
        }
        for (int i = 1; i <= zeroNums; i++) {
            nums[nums.length - i] = 0;
        }
    }

    public void moveZeroesSimple(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        // j代表目前将要移动的数字位置，i代表当前遍历的位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) nums[i] = 0;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3, 0, 5, 0, 7};
//        new MoveZeroes().moveZeroes(nums);
        new MoveZeroes().moveZeroesSimple(nums);
        System.out.println(nums);
    }
}
