package leetcode.problem.medium.array;

/**
 * @author : yuanqi
 * @since : 2021/1/21
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new MaxArea().maxArea(height));
    }

    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int max = 0;
        while (low < high) {
            max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return max;
    }
}
