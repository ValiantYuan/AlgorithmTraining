package leetcode.primarytest.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {
	List<Integer> values = new ArrayList<>();
	
	
	/**
	 * 递归遍历，结构简单，但是非常占用内存，重复计算太多，效率往往不高
	 * @param root
	 */
	public void preOrderTraversalIteration(TreeNode root) {
		if (root != null) {
			visit(root);
			preOrderTraversalIteration(root.left);
			preOrderTraversalIteration(root.right);
		}
	}
	
	public void inOrderTraversalIteration(TreeNode root) {
		if (root != null) {
			preOrderTraversalIteration(root.left);
			visit(root);
			preOrderTraversalIteration(root.right);
		}
	}
	
	public void postOrderTraversalIteration(TreeNode root) {
		if (root != null) {
			preOrderTraversalIteration(root.left);
			preOrderTraversalIteration(root.right);
			visit(root);
		}
	}
	
	/**
	 * 非递归一般才是真正高效的算法
	 * https://www.cnblogs.com/jdneo/p/5394489.html
	 * @param root
	 */
	public void preOrderTraversal(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		visit(root);
		stack.push(root);
		TreeNode top = null;
		TreeNode lastPop = root;
		while (!stack.isEmpty() ) {
			top = stack.peek();
			if (top.left != null && top.left != lastPop && top.right != lastPop) {
				visit(top.left);
				stack.push(top.left);
			} else if (top.right != null && top.right != lastPop) {
				visit(top.right);
				stack.push(top.right);
			} else {
				lastPop = stack.pop();
			}
		}
	}
	
	public void inOrderTraversal(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode top = null;
		TreeNode lastPop = root;
		while (!stack.isEmpty() ) {
			top = stack.peek();
			if (top.left != null && top.left != lastPop && top.right != lastPop) {
				stack.push(top.left);
			} else if (top.right != null && top.right != lastPop) {
				visit(top);
				stack.push(top.right);
			} else {
				lastPop = stack.pop();
				if (top.right == null) visit(top);
			}
		}
	}
	
	public void postOrderTraversal(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode top = null;
		TreeNode lastPop = root;
		while (!stack.isEmpty() ) {
			top = stack.peek();
			if (top.left != null && top.left != lastPop && top.right != lastPop) {
				stack.push(top.left);
			} else if (top.right != null && top.right != lastPop) {
				stack.push(top.right);
			} else {
				visit(top);
				lastPop = stack.pop();
			}
		}
	}

	/**
	 * 访问节点时的操作
	 * @param node
	 */
	public void visit(TreeNode node) {
		values.add(node.val);
	}
	
	
	
	
	
	
}
