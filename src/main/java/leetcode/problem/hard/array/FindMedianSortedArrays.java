package leetcode.problem.hard.array;

/**
 * @author : yuanqi
 * @since : 2021/1/10
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays2(nums1, nums2));
    }

    /**
     * 暴力法，顺序遍历数组找到mid和preMid，算出中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        int mid = 0;
        int preMid = 0;
        for (int k = 0, i = 0, j = 0; k <= totalLength / 2; k++) {
            if (i < length1 && j < length2) {
                if (nums1[i] <= nums2[j]) {
                    preMid = mid;
                    mid = nums1[i];
                    i++;
                } else {
                    preMid = mid;
                    mid = nums2[j];
                    j++;
                }
            } else if (i < length1) {
                preMid = mid;
                mid = nums1[i];
                i++;
            } else if (j < length2) {
                preMid = mid;
                mid = nums2[j];
                j++;
            }
        }
        if (totalLength % 2 == 0) {
            return (preMid + mid) / 2.0;
        }
        return mid;
    }

    /**
     * 找到第k大的值
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        int midIndex = totalLength / 2;
        int count = 0;
        int pos1 = -1;
        int pos2 = -1;
        while (count < midIndex) {
            if (nums1[pos1 + midIndex / 2] <= nums2[pos2 + midIndex / 2]) {
                count += midIndex / 2;
                pos1 += midIndex / 2;
                midIndex -= midIndex / 2;
            } else if (nums1[pos1 + midIndex / 2] > nums2[pos2 + midIndex / 2]) {
                count += midIndex / 2;
                pos2 += midIndex / 2;
                midIndex -= midIndex / 2;
            }
        }
        return 0;
    }


    /**
     * 把两个数组分别进行切割，左侧个数与右侧个数相等，且左侧较大的值，比右侧较小的值还要小
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 把nums1指定为比较短的那个数组
        if (nums1.length > nums2.length) {
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int halfCount = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left < right) {
            // 假设在二分的时候认为让左侧多一个,所以
            // [0,1]二分为[0],[1];[0,1,2]二分为[0,1],[2]
            // i代表右侧的第一个下表，也代表左侧
            int i = (left + right + 1) / 2;
            int j = halfCount - i;
            // 想要满足中位数的条件，需要nums1[i - 1] <= nums2[j] && num[i] >= num[j - 1]
            // 如果数组1的左侧最大值比数组2的右侧最小值大，则需要把数组1的左值往左继续移动，所以缩小right的范围
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                // 仅仅满足条件上面一个条件还不够，还有num[i] >= num[j - 1]需要满足，
                // 所以当还要缩小left的范围
                left = i;
            }
        }
        // 退出循环时，已经确定了划分中位数时，nums1中左侧的范围[0 - m]之间
        int i = left;
        int j = halfCount - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        // 当num1 = {1, 2}, nums = {3, 4}时，j == 0
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        // 当nums1为空是，nums2只有1个值是，j == n,日吃需要把
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        return (m + n) % 2 != 0
            ? Math.max(nums1LeftMax, nums2LeftMax)
            : (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
    }


}
