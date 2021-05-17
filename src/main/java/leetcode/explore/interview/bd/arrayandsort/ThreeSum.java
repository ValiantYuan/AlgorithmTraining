package leetcode.explore.interview.bd.arrayandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @NAME: ThreeSum
 * @USER: valiant
 * @DATE: 2019-09-26
 * @DESCRITION:
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = nums.length;
        if(length < 3) {
            return result;
        }
        Arrays.sort(nums);
        //边界条件
        if (nums[0] > 0 || nums[length - 1] < 0) {
            return result;
        }
        for(int i  = 0; i < nums.length; i++) {
            //如果三个数中最小的一个也大于0，则无法产生答案
            if (nums[i] > 0) {
                break;
            }
            //如果当前元素和前一个元素相等，则跳过不处理，对于nums[i] = num[i - 1] = 0 这种情况，已经在前一次处理过了
            //而对于其他数值相等的情况，可以直接跳过不处理，这里算一步去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = length - 1;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    //当前组合满足了条件，加入到结果集中
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    result.add(list);
                    //对下限值去重后继续
                    while(low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    //对上限值去重后继续
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    //特别注意这里，不能忘记修改上下限对值
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = new ThreeSum().threeSum(nums);
        System.out.println(list);
    }
}
