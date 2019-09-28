package leetcode.bd.sortandarray;

/**
 * @NAME: FindRotateIndex
 * @USER: valiant
 * @DATE: 2019-09-26
 * @DESCRITION: 假设按照升序排序的数组在预先未知的某个点上进行了旋转
 * (例如 ， 数组   [0, 1, 2, 4, 5, 6, 7]   可能变为   [4, 5, 6, 7, 0, 1, 2]  )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 **/
public class FindRotateIndex {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        return search(nums, target, 0, length - 1);
    }

    /**
     * 这个解法中，特别注意边界条件都是大于等于或者小于等于，不然会出错？
     * 因为middle在计算时，可能会与start或者end重合，所以要考虑相等的情况
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    public int search(int[] nums, int target, int start, int end) {
        //
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int middle = (start + end) / 2;
        //如果值相等，则返回结果
        if (target == nums[middle]) {
            return middle;
        }
        //middle如果在翻转发生前，且target小于middle值
        else if (nums[start] <= nums[middle] && target < nums[middle]) {
            //如果target大于等于start，则缩小end到middle - 1
            if (target >= nums[start]) {
                return search(nums, target, start, middle - 1);
            } else {
                //如果target小于start，则扩大start到middle + 1
                return search(nums, target, middle + 1, end);
            }
        }
        //middle如果在翻转发生前，且target大于middle值，则扩大start到middle + 1；
        else if (nums[start] <= nums[middle] && target > nums[middle]) {
            return search(nums, target, middle + 1, end);
        }
        //middle如果在翻转发生后，且target小于middle值，则缩小end到middle - 1；
        else if (nums[start] >= nums[middle] && target < nums[middle]) {
            return search(nums, target, start, middle - 1);
        }
        //middle如果在翻转发生后，且targe大于middle
        else if (nums[start] >= nums[middle] && target > nums[middle]) {
            //如果targe大于
            if (target >= nums[start]) {
                return search(nums, target, start, middle - 1);
            } else {
                return search(nums, target, middle + 1, end);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] array = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 3;
        int[] array = {1, 3};
        int index = new FindRotateIndex().search(array, target);
        System.out.println(index);
    }
}
