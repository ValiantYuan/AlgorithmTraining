package leetcode.problem.medium.binarytree;

import java.util.HashMap;
import java.util.Map;

import basestructure.TreeNode;

/**
 * @author : yuanqi
 * @since : 2021/1/25
 */
public class BuildTreePreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorderMap, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap,
                              int preStart, int preEnd,
                              int inStart, int inEnd ) {
        // base case
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderIndex = inorderMap.get(preorder[preStart]);
        root.left = buildTree(preorder, inorderMap, preStart + 1, preStart - inStart + inorderIndex, inStart, inorderIndex - 1);
        root.right = buildTree(preorder, inorderMap, preStart - inStart + inorderIndex + 1, preEnd,  inorderIndex + 1, inEnd);
        return root;
    }


}
