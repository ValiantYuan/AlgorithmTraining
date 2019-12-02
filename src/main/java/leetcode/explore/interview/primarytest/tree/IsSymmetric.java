package leetcode.explore.interview.primarytest.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Valiant
 *
 */
public class IsSymmetric {
//    public boolean isSymmetric(TreeNode root) {
//    	return root == null || isSymmetric(root.left, root.right);
//    }
//
//    public boolean isSymmetric(TreeNode left, TreeNode right) {
//		if (left == null || right == null) return left == right;
//		if (left.val != right.val) return false;
//    	return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
//	}
    
//    public boolean isSymmetric(TreeNode root) {
//    	Queue<TreeNode> queue = new LinkedList<>();
//    	if (root == null) return true;
//    	if (root.left == null && root.right == null) return root.left == root.right;
//    	queue.offer(root.left);
//    	queue.offer(root.right);
//    	TreeNode node1 = null;
//    	TreeNode node2 = null;
//    	while (!queue.isEmpty()) {
//			node1 = queue.poll();
//			node2 = queue.poll();
//			if (node1.val != node2.val) return false;
//			if (node1.left != null) {
//				if (node2.right != null) {
//					queue.offer(node1.left);
//					queue.offer(node2.right);
//				} else return false;
//			} else if (node2.right != null) return false;
//			if (node1.right != null) {
//				if (node2.left != null) {
//					queue.offer(node1.right);
//					queue.offer(node2.left);
//				} else return false;
//			} else if (node2.left != null) return false;
//		}
//    	return true;
//    }

    public boolean isSymmetric(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	if (root == null) return true;
    	if (root.left == null && root.right == null) return root.left == root.right;
    	queue.offer(root.left);
    	queue.offer(root.right);
    	TreeNode node1 = null;
    	TreeNode node2 = null;
    	while (!queue.isEmpty()) {
			node1 = queue.poll();
			node2 = queue.poll();
			if (node1 == node2) continue;
			if (node1 == null ^ node2 == null) return false;
			if (node1.val != node2.val) return false;
			queue.offer(node1.left);
			queue.offer(node2.right);
			queue.offer(node1.right);
			queue.offer(node2.left);
		}
    	return true;
    }
    public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(2);
//		head.right = new TreeNode(2);
//		head.left.left = new TreeNode(3);
//		head.left.right = new TreeNode(4);
//		head.right.left = new TreeNode(2);
//		head.right.right = new TreeNode(3);
		boolean result = new IsSymmetric().isSymmetric(head);
		System.out.println(result);
	}
}
