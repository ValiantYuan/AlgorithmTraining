package leetcode.problem.medium.binarytree;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2021/1/22
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Flatten {
    // 1.交换左右子树
    // 2.把左子树接到右子树的叶节点右侧
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 递归处理左子树，右子树
        flatten(root.left);
        flatten(root.right);
        // 把左子树拼到右子树叶节点右侧
        tmp = root;
        while(tmp.right != null) {
            tmp = tmp.right;
        }
        tmp.right = root.left;
        root.left = null;
    }
}
