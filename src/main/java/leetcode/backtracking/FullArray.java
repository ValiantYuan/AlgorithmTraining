package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description:
 * @Author: YuanQi
 * @Date: 2020/3/29
 */
public class FullArray {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 5, 1, 7};
        new FullArray().test(nums);
    }


    public void test(int[] nums) {
        List<Integer> result = new ArrayList<>();
        addOne(nums, 0, result);
    }

    public void addOne(int[] nums, int index, List result) {
        if (index == nums.length) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
            }
            System.out.println();
            return;
        }
        for (int i = index; i < nums.length; i++) {
            result.add(nums[i]);
            swap(index, i, nums);
            addOne(nums, ++index, result);
            result.remove(result.size() - 1);
            swap(i, --index, nums);
        }
    }

    public void swap(int target, int source, int[] nums) {
        int temp = nums[target];
        nums[target] = nums[source];
        nums[source] = temp;
    }


}
