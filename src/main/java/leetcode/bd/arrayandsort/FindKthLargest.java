package leetcode.bd.arrayandsort;

/**
 * @NAME: FindKthLargest
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION: 找到第k大的数字
 **/
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int partition;
        int start = 0;
        int end = length - 1;
        while (true) {
            partition = partition(nums, start, end);
            //由于要找第k大，数组从0开始计数，所以在数组中的位置是k - 1
            if (partition == k - 1) {
                return nums[partition];
            } else if (partition > k - 1) {
                end = partition - 1;
            } else {
                start = partition + 1;
            }
        }
    }


    public int partition(int[] nums, int start, int end) {
        int j = start;
        for (int i = start; i < end; i++) {
            //按照从大到小排序，end作为分区点的值,
            // j之前都是大于nums[end]的值，j之后都是小于nums[end]的值
            if (nums[i] >= nums[end]) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, end);
        return j;

    }

    public void swap(int[] nums, int a, int b) {
        int tmp;
        tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {3,2,1,5,6,4};
        int k = 2;
        int value = new FindKthLargest().findKthLargest(array, k);
        System.out.println(value);
    }
}
