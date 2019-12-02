package leetcode.explore.interview.mediumtest.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @NAME: Permute
 * @USER: valiant
 * @DATE: 2019-09-22
 * @DESCRITION: 给定一个没有重复数字的序列，返回其所有可能的全排列。
 **/
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        if(length == 0) {
            return null;
        }
        ArrayList<Integer> numsArray = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int num : nums) {
            numsArray.add(num);
        }
        backtrack(length, numsArray, resultList, 0);
        return resultList;
    }

    /**
     *
     * @param length    所要进行全排列数组的长度
     * @param nums      要进行全排列的数组链表
     * @param result    满足条件的结果集合
     * @param firstPos  当前要排列的值的位置
     */
    private void backtrack(int length, ArrayList<Integer> nums, List<List<Integer>> result, int firstPos) {
        //退出条件
        if (firstPos == length) {
            result.add(new ArrayList<>(nums));
        }
        //按顺序将从firstPos开始的值放置到firstPos位置，然后递归处理数组后续位置的值
        for (int i = firstPos; i < length; i++) {
            //交换firstPos和i的位置，相当于啊把第i个值放置到firstPos位置上
            Collections.swap(nums, firstPos, i);
            backtrack(length, nums, result, firstPos + 1);
            //对数组进行还原，不影响其他递归操作
            Collections.swap(nums, firstPos, i);
        }
    }

}
