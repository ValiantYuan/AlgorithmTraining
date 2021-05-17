package leetcode.problem.simple.tree;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2021/1/22
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
