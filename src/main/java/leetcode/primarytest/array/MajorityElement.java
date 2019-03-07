package leetcode.primarytest.array;
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。
 * @author Valiant
 *
 */
public class MajorityElement {
	public int majorityElement(int nums[]) {
		int count = 1;
		int major = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			}
			else if (major == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}
}
