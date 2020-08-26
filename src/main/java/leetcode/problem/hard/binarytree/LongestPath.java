package leetcode.problem.hard.binarytree;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2020/8/10
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */

public class LongestPath {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getLongestPath(root);
        return result;
    }

    /**
     * 获取从当前节点出发，在子树中寻找最长的路径，返回路径长度
     * @param node
     * @return
     */
    public int getLongestPath(TreeNode node) {
        if (null == node) {
            return 0;
        }
        // 如果子树最大长度为负数或者0，则不考虑子树
        int leftLongestPath = Math.max(getLongestPath(node.left), 0);
        int rightLongestPath = Math.max(getLongestPath(node.right), 0);
        // 经过当前路径的，同时经过左右子树的最长路径长度
        int curPath = leftLongestPath + rightLongestPath + node.val;
        result = Math.max(curPath, result);
        return node.val + Math.max(leftLongestPath, rightLongestPath);
    }
}
