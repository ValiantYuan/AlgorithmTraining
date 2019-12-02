package leetcode.explore.interview.primarytest.sortandsearch;

public class MergeTwoSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        m -= 1;
        n -= 1;
        int insertPosition = m + n + 1;
        while (m >= 0 && n >=0) {
        	if (nums1[m] > nums2[n]) {
				nums1[insertPosition--] = nums1[m--];
			} else if (nums1[m] <= nums2[n] ) {
				nums1[insertPosition--] = nums2[n--];
			}
        }
        if (m < 0) {
        	for (int i = 0; i <= n; i++) {
				nums1[i] = nums2[i];
        	}
        }
	}
}
