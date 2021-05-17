package leetcode.problem.medium.binarytree;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2021/1/25
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode treeNode = new ConstructMaximumBinaryTree().constructMaximumBinaryTree(nums);
        return;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return func(nums, 0, nums.length - 1);
    }

    public TreeNode func(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int max = findMaxInRange(nums, start, end);
        TreeNode root = new TreeNode(nums[max]);
        root.left = func(nums, start, max - 1);
        root.right = func(nums, max + 1, end);
        return root;
    }


    private int findMaxInRange(int[] nums, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
}
