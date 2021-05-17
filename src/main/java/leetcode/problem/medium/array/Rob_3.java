package leetcode.problem.medium.array;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2021/1/20
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class Rob_3 {

    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dp(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int rob = root.val + left[0] + right[0];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {notRob, rob};
    }

}
