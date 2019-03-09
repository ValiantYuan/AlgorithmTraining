package leetcode.primarytest.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @author Valiant
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepth {
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }
    public int maxDepth(TreeNode root) {
    	int height = 0;
    	if (root == null) return height;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	TreeNode tmp = null;
    	int level = 0;
    	int length = 0;
    	while (!queue.isEmpty()) {
    		length = queue.size();
    		level++;
    		while (length > 0) {
    			tmp = queue.poll();
    			length--;
    			if(tmp.left != null) queue.offer(tmp.left);
    			if (tmp.right != null) queue.offer(tmp.right);
			}
    	}
    	return level;
    }
}


